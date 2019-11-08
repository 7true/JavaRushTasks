package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public static void main(String[] args) {

    }

    public A getOriginalObject(ObjectInputStream objectStream) {
        A a;
        try {
            a = (A) objectStream.readObject();
        } catch (Exception e) {
            return null;
        }
        return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
