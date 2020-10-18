package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        String str1 = "aaabbcccdaa";
        String str2 = " ";

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (ch != str2.charAt(str2.length() - 1)) {
                str2 += ch;
            }
        }
        System.out.println(str2);
        int numRings = 8;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        if (numRings > 0) {
            moveRing(a, c, b, numRings - 1);
            System.out.println("from "  + a + " to " + b);
            moveRing(c, b, a, numRings - 1);
        }
    }
}