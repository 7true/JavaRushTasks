package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileIn = new BufferedReader(new FileReader(br.readLine()));
            BufferedWriter fileOut = new BufferedWriter(new FileWriter(br.readLine()));

            String line = "";
            while (fileIn.ready()) {
                int data = fileIn.read();
                line = line + (char)data;
            }

            line = line.replaceAll("\\.","!");

            fileOut.write(line);
            br.close();
            fileIn.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
