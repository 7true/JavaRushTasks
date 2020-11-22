package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        System.out.println(packageName);
        File dir = new File(packageName);
        ClassLoader classLoader = Solution.class.getClassLoader();
        for (String fileName : dir.list()) {
            if (fileName.endsWith(".class")) {
                String className = packageName.replaceAll("[/\\\\]", ".").substring(packageName.indexOf("com")) + "." + fileName.substring(0, fileName.length() - 6);
                Class<?> aClass = classLoader.loadClass(className);
                hiddenClasses.add(aClass);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        Class result = null;
        try {
            for (Class clazz : hiddenClasses) {
                if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                    result = clazz;
                    Constructor<?> constructor = result.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return (HiddenClass) constructor.newInstance();
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}

