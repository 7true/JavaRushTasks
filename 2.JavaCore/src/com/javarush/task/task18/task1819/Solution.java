package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file1 = br.readLine();

            FileInputStream fis1 = new FileInputStream(file1);
            FileInputStream fis2 = new FileInputStream(br.readLine());
            int countOfBytes = fis1.available();
            byte[] bytesArr1 = new byte[fis1.available()];
            byte[] bytesArr2 = new byte[fis2.available()];

            fis1.read(bytesArr1);
            fis2.read(bytesArr2);

            FileOutputStream fout = new FileOutputStream(file1);

            fis1.close();
            fis2.close();
            fout.write(bytesArr2);
            fout.write(bytesArr1);
            br.close();

            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
