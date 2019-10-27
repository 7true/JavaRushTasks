package com.javarush.task.task20.task2025;

import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {

        ArrayList<Long> res = new ArrayList<>();
        long current = 1;
        for (; current < N; current++) {
            if (String.valueOf(current).length() == 1) {
                res.add(Long.valueOf(current));
            }
            else if (isArmStrongNumber(current)) {
                res.add(current);
            }

        }
        long[] result = new long[res.size()];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return result;
    }

    public static boolean isArmStrongNumber (long number) {
        long result = 0;
        String snumber = String.valueOf(number);
        int len = snumber.length();
        long curDig = 0;
        for (int i = 0; i < len; i++) {
            curDig = (int)snumber.charAt(i)-'0';
            for (int j = 0; j < len-1; j++) {
                curDig = curDig * curDig;
            }
            result += curDig;
            //result += Math.pow(curDig, len);
            if (result > number) {
                return false;
            }
        }
        if (result != number) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        long result [] = getNumbers(1000);
        for (long l : result) {
            System.out.println(l);
        }
    }
}
