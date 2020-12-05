package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest a = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String fqn : a.fullyQualifiedNames()) {
                System.out.println(fqn);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest a = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class<?> v : a.value()) {
                System.out.println(v);
            }
            return true;
        }
        return false;
    }
}
