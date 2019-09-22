package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            ArrayList<Integer> symbols = new ArrayList<>();
            while (fis.available() > 0) {
                symbols.add(fis.read());
            }

            Map<Character, Integer> result = new TreeMap<>();
            Collections.sort(symbols);

            for (int x : symbols) {
                int freq = Collections.frequency(symbols, x);
                result.put((char)x, freq);
            }

            for (Map.Entry<Character, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
