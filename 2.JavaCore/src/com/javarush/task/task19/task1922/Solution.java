package com.javarush.task.task19.task1922;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("А");
        words.add("Б");
        words.add("В");
    }

    public static void main(String[] args) {
        ArrayList<String[]> fileContent = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));

            while (fr.ready()) {
                fileContent.add(fr.readLine().split("\\s"));
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = 0;
        for (String s []: fileContent) {
            for (String word : words) {
                for (int i = 0; i < s.length; i++) {
                    if (s[i].equals(word))
                        count++;
                }
            }
            if (count == 2) {
                for (int j = 0; j < s.length; j++) {
                    if (j == s.length - 1) {
                        System.out.print(s[j]);
                        System.out.println();
                    } else
                        System.out.print(s[j] + " ");

                }
            }
            count = 0;
        }

    }
}
