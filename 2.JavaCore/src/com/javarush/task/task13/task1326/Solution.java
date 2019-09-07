package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            ArrayList<Integer> arr = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {

                Integer i = Integer.parseInt(line);

                if (Math.abs(i)% 2 == 0)
                    arr.add(i);
            }
            Collections.sort(arr);
            for (Integer i : arr) {
                System.out.println(i);
            }
            fis.close();
            isr.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
