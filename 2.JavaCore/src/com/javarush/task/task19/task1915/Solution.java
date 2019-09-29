package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //BufferedWriter bout = new BufferedWriter(new FileWriter(br.readLine()));
            FileOutputStream fout = new FileOutputStream(br.readLine());
            PrintStream consoleStream = System.out;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(outputStream);
            System.setOut(stream);
            testString.printSomething();
            System.setOut(consoleStream);
            String result = outputStream.toString();
            System.out.println(result);

            fout.write(result.getBytes());
            fout.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

