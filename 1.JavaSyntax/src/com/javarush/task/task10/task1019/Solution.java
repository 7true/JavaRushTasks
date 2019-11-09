package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        String line;
        while (!(line = reader.readLine()).isEmpty()) {
                if (line.isEmpty()) break;
                int id = Integer.parseInt(line);
                String name = reader.readLine();
                map.put(name, id);
        }

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = it.next();
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }

}
