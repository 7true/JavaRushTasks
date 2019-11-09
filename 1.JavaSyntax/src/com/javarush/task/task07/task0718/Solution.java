package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            list.add(r.readLine());
        int len = list.get(0).length();
        for(int i = 0; i < list.size(); i++) {
            if (len > list.get(i).length()) {
                len = i;
                System.out.println(len);
                break;
            }
            len = list.get(i).length();
        }
    }
}

