package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();

            FileReader fr = new FileReader(fileName);
            String line = "";
            while (fr.ready()) {
                int data = fr.read();
                line = line + (char)data;
            }
            int count = 0;
            String[] arr = line.split("\\W+");
            //System.out.println(line);
            if (arr.length == 0) {
                if (line.equals("world"))
                    count++;
            }
            for (String i : arr) {
                if (i.equals("world")) {
                    count++;
                }
            }
            System.out.println(count);
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
