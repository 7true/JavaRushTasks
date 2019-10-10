package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new FileReader(brr.readLine()));
            while (br.ready()) {
                String line = br.readLine();
                System.out.println(new StringBuilder(line).reverse());
            }

            brr.close();
            br.close();
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
