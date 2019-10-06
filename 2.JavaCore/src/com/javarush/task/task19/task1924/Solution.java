package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4,"четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileContent = new ArrayList<>();
        try {
            BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
            br.close();;
            while (fr.ready()) {
                fileContent.add(fr.readLine());
            }
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : fileContent) {

            String [] words = s.split("\\s");
            for (int i = 0; i < words.length; i++) {
                if (isNumeric(words[i]))
                    if (map.containsKey(Integer.valueOf(words[i]))) {
                        //System.out.println(map.get(Integer.valueOf(words[i])));
                        //System.out.println(words[i]);
                        s = s.replaceFirst(words[i], map.get(Integer.valueOf(words[i])));
                    }
            }
            System.out.println(s);
        }


    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
