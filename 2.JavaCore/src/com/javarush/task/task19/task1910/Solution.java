package com.javarush.task.task19.task1910;

/* 
Пунктуация
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

            line = line.replaceAll("\\p{Punct}","");

            fileOut.write(line);
            br.close();
            fileIn.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
