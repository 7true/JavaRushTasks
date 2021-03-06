package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        try {
            raf.seek(Integer.parseInt(args[1]));
            raf.seek(Math.min(raf.length(),Integer.parseInt(args[1])));
        } catch (IOException e) {
        }
        raf.write(args[2].getBytes());
    }
}
