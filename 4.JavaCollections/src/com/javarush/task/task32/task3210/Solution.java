package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        int length = args[2].length();
        try {
            int number = Integer.parseInt(args[1]);
            raf.seek(number);
            byte[] fileBytes = new byte[length];
            String.valueOf(raf.read(fileBytes, 0, length));
            String text = new String(fileBytes);
            raf.seek(raf.length());
            if (text.equals(args[2])) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        raf.close();
    }
}
