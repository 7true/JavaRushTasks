package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer st = new StringTokenizer(query, delimiter);
        List<String> parts = new ArrayList<>();
        while (st.hasMoreElements()) {
         String token = st.nextToken();
         parts.add(token);
        }

        String[] result = parts.toArray(new String[parts.size()]);
        return  result;
    }
}
