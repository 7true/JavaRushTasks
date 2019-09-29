package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = br.readLine();
            String fileName2 = br.readLine();
            FileReader fr = new FileReader(fileName1);
            FileWriter fw = new FileWriter(fileName2);
            int count = 0;
            while (fr.ready()) {
                int data = fr.read();
                count++;
                if (count % 2 == 0) {
                    fw.write(data);
                }

            }
            br.close();
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
