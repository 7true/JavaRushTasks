package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filePath = reader.readLine();
            InputStream in = new FileInputStream(filePath);
            BufferedInputStream buffer= new BufferedInputStream(in);

            while (buffer.available() > 0) {
                char c = (char)buffer.read();
                System.out.print(c);
            }
            reader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}