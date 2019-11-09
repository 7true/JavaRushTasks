package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List longs = new ArrayList<Long>();
        longs.add(1L);
        longs.add(1.0);
        longs.add(new Object());
        longs.add("I am LONG!");

        for (Object x : longs) {
            System.out.println(x);
        }
    }
}
