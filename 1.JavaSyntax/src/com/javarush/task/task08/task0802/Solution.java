package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Map<String,String> meal = new HashMap<>();
        meal.put("арбуз", "ягода");
        meal.put("банан", "трава");
        meal.put("вишня", "ягода");
        meal.put("груша", "фрукт");
        meal.put("дыня", "овощ");
        meal.put("ежевика", "куст");
        meal.put("жень-шень", "корень");
        meal.put("земляника", "ягода");
        meal.put("ирис", "цветок");
        meal.put("картофель", "клубень");

        Iterator<Map.Entry<String, String>> it = meal.entrySet().iterator();

        for (;it.hasNext();) {
            Map.Entry<String, String> pair = it.next();
            System.out.print(pair.getKey() + " - " + pair.getValue());
            System.out.println();
        }

    }
}
