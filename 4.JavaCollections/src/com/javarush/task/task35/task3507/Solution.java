package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {

        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/")) {
            pathToAnimals = pathToAnimals + "/";
        }
        File dir = new File(pathToAnimals);
        String[] paths = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });
        Set<Animal> set = new HashSet<>();
        for (String p : paths) {
            try {
                String finalPathToAnimals = pathToAnimals;
                boolean hasInterfaceAnimals = false;
                boolean hasConstructor = false;

                ClassLoader loader = new ClassLoader() {
                    @Override
                    protected Class<?> findClass(String name) throws ClassNotFoundException {
                        try {
                            byte b[] = fetchClassFromFS(finalPathToAnimals + name + ".class");
                            return defineClass(null, b, 0, b.length);
                        } catch (IOException e) {
                            return super.findClass(name);
                        }
                    }
                };

                String className = p.substring(0, p.length() - 6);
                Class clazz = loader.loadClass(className);
                Class[] interfaces = clazz.getInterfaces();

                for (Class i : interfaces) {
                    if (Animal.class == i) {
                        hasInterfaceAnimals = true;
                        break;
                    }
                }
                if (!hasInterfaceAnimals) {
                    continue;
                }

                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors) {
                    if (c.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }

                if (!hasConstructor) {
                    continue;
                }

                set.add((Animal) clazz.getDeclaredConstructor().newInstance());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        return set;
    }


    private static byte[] fetchClassFromFS(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        // Get the size of the file
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}
