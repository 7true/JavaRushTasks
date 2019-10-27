package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long degreeTable[][] = new long[10][10];
    public static long[] getNumbers(long N) {

        ArrayList<Long> res = new ArrayList<>();
        Set<Long> sorted = new TreeSet<>();
        for (long i = 1; i < N; i++) {
            String snumber = String.valueOf(i);
            int prev = Integer.MAX_VALUE;
            int flag = 0;
            int len = snumber.length();
            long iBef = i;
            for (int j = 0; j < len; j++) {
                int curDig = (int) i % 10;
                i = i/10;
                if (curDig <= prev)
                    flag = 1;
                else
                    flag = 0;
                prev = curDig;
            }
            i = iBef;
            if (flag == 0) {
                sorted.add(i);
            }

        }
        long current = 1;
            System.out.println(sorted.size());
        for (long l : sorted) {
            if (String.valueOf(l).length() == 1) {
                res.add(l);
            }
            else  {
                String snumber = String.valueOf(l);
                long result = 0;
                int len = snumber.length();
                long curDig = 0;
                for (int i = 0; i < len; i++) {
                    curDig = (long) snumber.charAt(i) - '0';
                    result += degreeTable[(int)curDig][len];
                }
                //System.out.println(l);
                if (isArmStrongNumber(result)) {
                    res.add(result);
                }
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
        long prev = 0;
        long next = 0;
        for (int i = 0; i < len; i++) {
            curDig = (long)snumber.charAt(i)-'0';
            /*
            long tmpCurrent = curDig;
            for (int j = 0; j < len-1; j++) {
                curDig = curDig * tmpCurrent;
            }
            result += curDig;
*/

            //result += Math.pow(curDig, len);
            result += degreeTable[(int)curDig][len];
            if (result > number) {
                return false;
            }
            // prev = tmpCurrent;
        }
        if (result != number) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                degreeTable[i][j] = (long) Math.pow(i, j);
            }
        }
        long startTime = System.nanoTime();
        long result [] = getNumbers(10000000);
        for (long l : result) {
            System.out.println(l);
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println(duration/1000000000 +" sec");
    }
}
