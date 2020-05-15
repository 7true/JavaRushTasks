package com.javarush.task.task30.task3009;

/* 
Палиндром?
*/

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> result = new HashSet<>();

        for (int r = 2; r < 37; ++r) {
            try {
                BigInteger n = new BigInteger(number);
                String sNumber = n.toString(r);
                String reverseNumber = new StringBuilder(sNumber).reverse().toString();
                if (sNumber.equals(reverseNumber)) {
                    result.add(r);
                }
            } catch (NumberFormatException nfe) {

            }
        }
        return result;
    }
}