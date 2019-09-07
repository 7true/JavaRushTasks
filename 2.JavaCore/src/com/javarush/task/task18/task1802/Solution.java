package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int min = 32000, current = 0;
        while (fis.available() > 0) {
            current = fis.read();
            if (current < min)
                min = current;
        }
        System.out.println(min);
        fis.close();
        r.close();
    }
}
