package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String result = outputStream.toString();
        String [] arrRes = result.split("\\s");
        switch (arrRes[1]) {
            case "+":
                result = result + (Integer.parseInt(arrRes[0]) + Integer.parseInt(arrRes[2]));
                break;
            case "*":
                result = result + (Integer.parseInt(arrRes[0]) * Integer.parseInt(arrRes[2]));
                break;
            case "-":
                result = result + (Integer.parseInt(arrRes[0]) - Integer.parseInt(arrRes[2]));
                break;
            default:
                break;
        }
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.print ("3 + 6 = ");
        }
    }
}

