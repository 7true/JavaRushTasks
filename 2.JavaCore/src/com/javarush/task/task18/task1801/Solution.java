package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int max = 0, current = 0;
        while (fis.available() > 0) {
            current = fis.read();
            if (current > max)
                max = current;
        }
        System.out.println(max);
        fis.close();
        r.close();
    }
}
