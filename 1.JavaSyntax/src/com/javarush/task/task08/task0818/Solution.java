package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> mapSalary = new HashMap<>();
        for (int i = 100; i < 1001; i += 100) {
            mapSalary.put("man" + i, i);
        }
        return mapSalary;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Iterator <Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue() < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        /*Map<String, Integer> map = createMap();
        removeItemFromMap(map);
        for(Map.Entry<String, Integer> pair: map.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());*/
    }
}