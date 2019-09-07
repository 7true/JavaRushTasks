package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        br.close();
        SortedSet result = new TreeSet();
        while (fis.available() > 0) {
            result.add(fis.read());
        }
        fis.close();
        for (Object i : result) {
            System.out.print(i + " ");
        }
    }
}
