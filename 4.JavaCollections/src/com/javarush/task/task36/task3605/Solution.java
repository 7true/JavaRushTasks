package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader r = new BufferedReader(new FileReader(fileName));
        String result = "";
        while (r.ready()) {
            result += r.readLine();
        }
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < result.length(); ++i) {
            Character current = result.substring(i, i+1).charAt(0);
            if (Character.isLetter(current))
                set.add(Character.toLowerCase(current));
        }
        r.close();
        int i = 0;
        Iterator<Character> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next());
            ++i;
            if (i == 5) {
                break;
            }
        }
    }
}
