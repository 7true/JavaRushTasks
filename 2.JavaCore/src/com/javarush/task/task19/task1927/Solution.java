package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String [] st = outputStream.toString().split("\\n");
        int i = 0;
        for (String s :st) {
            System.out.println(s);
            i++;
            if ((i % 2) == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
        //Вызываем функцию, которая ничего не знает о наших манипуляциях

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
