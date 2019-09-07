package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put((double) 1, "ok");
        labels.put(2.3, "ok");
        labels.put(3.4, "ok");
        labels.put(4.5, "ok");
        labels.put(5.3, "ok");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
