package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = br.readLine();
            String fileName2 = br.readLine();

            FileInputStream fis1 = new FileInputStream(fileName1);
            FileOutputStream fout = new FileOutputStream(fileName2);
            BufferedReader brf = new BufferedReader((new InputStreamReader(fis1, StandardCharsets.UTF_8)));
            String line = brf.readLine();
            //System.out.println(line);
            String [] doubles = line.split(" ");

            for (int i = 0; i < doubles.length; i++) {
                double number = Double.parseDouble(doubles[i]);
                int rounded = (int) Math.round(number);
                fout.write(String.valueOf(rounded).getBytes());
                if (i == doubles.length - 1)
                    break;
                fout.write(" ".getBytes());
                System.out.println(rounded);
            }

            br.close();
            brf.close();
            fis1.close();
            fout.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
