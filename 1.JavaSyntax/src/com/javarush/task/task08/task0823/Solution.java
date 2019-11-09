package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String words[] = string.split(" ");
        List<String> arr = new ArrayList<>();
        arr = Arrays.asList(words);
        for (String str : arr) {
            if (str.length() != 0)
                str = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
            System.out.print(str + " ");
        }

    }
}
