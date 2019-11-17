package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Russia");
        map.put("city", "Krasnoyarsk");
        map.put("age", "31");

        String s = getQuery(map);
        System.out.println(s);
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder query = new StringBuilder();

        for (HashMap.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null || pair.getKey() == null) {
                query.append(pair.getKey() + " = '" + pair.getValue() + "' and ");
            }
        }

        try {
            return query.substring(0, query.length() - 5);

        } catch (Exception e) {
            return "";
        }
    }
}
