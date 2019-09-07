package com.javarush.task.task14.task1419;


import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
            ArrayList<String> s = new ArrayList<>();
            s.add("d");
            s.get(200);

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            ArrayList<String> s = new ArrayList<>();
            s.add("d");
            s.get(200);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            File file = new File("E://file.txt");
            FileReader fr = new FileReader(file);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int num = Integer.parseInt ("akki") ;

            System.out.println(num);
        } catch (Exception e) {
            exceptions.add(e);
        }


        try {
            int a[] = new int[5];
            a[6] = 9; // accessing 7th element in an array of
            // size 5
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String a = "This is like chipping "; // length is 22
            char c = a.charAt(24); // accessing 25th element
            System.out.println(c);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String a = null; //null value
            System.out.println(a.charAt(0));
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Scanner inputDevice = new Scanner("kjhkj");
            int age = inputDevice.nextInt();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int a[] = new int[-5];
            a[6] = 9;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new ClassCastException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }

}