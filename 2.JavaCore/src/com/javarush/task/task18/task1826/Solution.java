package com.javarush.task.task18.task1826;

/*
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[1]);
            FileOutputStream fout = new FileOutputStream(args[2]);

            //encrypt func
            while (fis.available() > 0) {
                int currentByte = fis.read();
                int cryptoByte = currentByte ^ 1;
                fout.write(cryptoByte);
            }
            fis.close();
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
