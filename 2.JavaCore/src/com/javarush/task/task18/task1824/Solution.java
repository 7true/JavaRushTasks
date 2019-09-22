package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        while (true) {
            fileName = br.readLine();
            try {
                fis = new FileInputStream(fileName);
                fis.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                br.close();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
