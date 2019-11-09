package com.javarush.task.task08.task0801;

/* 
Set из растений
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Set<String> fAndV = new HashSet<>();
        fAndV.add("арбуз");
        fAndV.add("банан");
        fAndV.add("вишня");
        fAndV.add("груша");
        fAndV.add("дыня");
        fAndV.add("ежевика");
        fAndV.add("женьшень");
        fAndV.add("земляника");
        fAndV.add("ирис");
        fAndV.add("картофель");
        for (String x : fAndV)
            System.out.println(x);
    }
}
