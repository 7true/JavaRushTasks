package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fis = new FileInputStream(br.readLine());
            FileOutputStream fout = new FileOutputStream(br.readLine());
            int availableIn = fis.available();
            byte[] buffer = new byte[availableIn];
            fis.read(buffer);
            for (int i = buffer.length - 1; i >=0; i--) {
                fout.write(buffer[i]);
            }
            br.close();
            fis.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
