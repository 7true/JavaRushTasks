package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        try {
            String file = reader.readLine();
            FileOutputStream out = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(out);
            FileWriter fileReader = new FileWriter(file);
            BufferedWriter bWr = new BufferedWriter(fileReader);
            while (true) {
                String line = reader.readLine();
                if (line.equals("exit")) {bWr.write(line + "\n"); break;}
               // dos.writeChars(line);
               // dos.writeChars("\n");
                bWr.write(line + "\n");
            }
            out.close();
            dos.close();
            bWr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
