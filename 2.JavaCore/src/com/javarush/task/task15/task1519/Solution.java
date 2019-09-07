package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        ArrayList<Object> arr = new ArrayList<>();
        while (!(line = reader.readLine()).equals("exit")) {
            if (line.equals("exit")) break;
            arr.add(line);
        }

        for (Object o : arr) {
            //System.out.println(o);
            try {
                if (o.toString().contains(".")) {
                    print(Double.parseDouble(o.toString()));
                }
                else if (Integer.valueOf(o.toString()) <= 0 || Integer.valueOf(o.toString()) >= 128) {
                    print(Integer.valueOf(o.toString()));
                }
                else if (Short.valueOf(o.toString()) > 0 && Short.valueOf(o.toString()) < 128) {
                    print(Short.valueOf(o.toString()));
                }

                else print(o.toString());
            }
            catch (Exception e) {
                print(o.toString());
            }

        }
    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
