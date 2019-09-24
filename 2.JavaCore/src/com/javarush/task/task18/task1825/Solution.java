package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        TreeMap<Integer, String> tree = new TreeMap<>();
        String lastNormalName = null;
        while(true) {
            try {
                if ((fileName = br.readLine()).equals("end")) {
                    br.close();
                    break;
                }
                //files.add(fileName);
                lastNormalName = fileName;
                String[] data = fileName.split(".part",2);
                tree.put(Integer.parseInt(data[1]), fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fout = new FileOutputStream(lastNormalName.split(".part")[0]);
            for (Map.Entry x : tree.entrySet()) {
                String file = String.valueOf(x.getValue());
                System.out.print(file + " ");
                System.out.println(x.getKey());
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fout.write(buffer);
                fis.close();
            }
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}