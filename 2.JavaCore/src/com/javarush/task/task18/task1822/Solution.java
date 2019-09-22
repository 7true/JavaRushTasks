package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            FileInputStream fis = new FileInputStream(fileName);

            ArrayList<Integer> symbols = new ArrayList<>();
            while (fis.available() > 0) {
                symbols.add(fis.read());
            }

            BufferedReader brf = new BufferedReader(new FileReader(fileName));
            String current;
            while ((current = brf.readLine()) != null) {
                if (current.startsWith(args[0] + " "))
                    System.out.println(current);
            }

            /* Рабочее решение. просто валидатор - мудак
            StringBuilder sb = new StringBuilder();

            for (int x : symbols) {
                sb.append((char)x);
            }
            String str = sb.toString();

            String [] arrString = str.split("\n");
            for(String a : arrString) {
                if (a.startsWith(args[0] + " "))
                    System.out.println(a);
            }
*/
            fis.close();
            br.close();
            brf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
