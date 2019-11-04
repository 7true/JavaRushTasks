
package com.javarush.task.task20.task2025;

import java.lang.reflect.Array;
import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long degreeTable[][];
    private static Set<Long> arrayArmstrong = new TreeSet<>();

    public static long[] getNumbers(long N) {
        arrayArmstrong = new TreeSet<>();

        int lengthN = String.valueOf(N).length();
        int[] digits = new int[lengthN];
        long n = N;
        for (int i = lengthN - 1; n > 0 ; i--) {
            long digit = n % 10;
            digits[i] = (int) digit;
            n /= 10;
        }

        degreeTable = getPowerArray(lengthN);
        int[][] genTable = genTableMax(digits);
        for (int i = 0; i < lengthN; i++) {
            generateSeq(genTable[i], N);
        }

        long[] result = new long[arrayArmstrong.size()];
        int c = 0;
        for (Long l : arrayArmstrong) {
            result[c++] = l;
        }
        return result;
    }
    private static int[][] genTableMax(int[] digs) {
        int[][] result = new int[digs.length][];
        for (int i = 0; i < digs.length; i++) {
            result[i] = new int[i + 1];
        }
        result[digs.length - 1] = digs;
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = 9;
            }
        }
        return result;
    }
    private static long[][] getPowerArray(int num) {
        num++;
        long[][] result = new long[10][num];
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < num; j++) {
                result[i][j] = longPower(i, j);
            }
        }
        return result;
    }
    private static void searchAddArmstrong(int[] arr, long N) {
        long arrayPowerSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrayPowerSum += degreeTable[arr[i]][arr.length];
        }

        if (isArmStrongNumber(arrayPowerSum, N) && arrayPowerSum < N) {
            arrayArmstrong.add(arrayPowerSum);
        }
    }

    private static long longPower(int num, int power) {
        long result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }
    private static void generateSeq(int[] arr, long N) {
        if (arr.length > 1) {
            int last = arr.length - 1;
            while (true) {
                while (arr[last] >= arr[last - 1]) {
                    searchAddArmstrong(arr, N);
                    if (arr[last] < 1 & arr[0] < 1) break;
                    arr[last]--;
                }
                for (int i = last - 1; i > -1; i--) {
                    if (arr[i] > arr[i + 1]) {
                        arr[i]--;
                        arr[i + 1] = 9;
                    }
                }
                if (arr[last] < 1) break;
            }
        } else {
            for (int i = arr[0]; i > 0; i--) {
                if (i < N) {
                   arrayArmstrong.add((long)i);
                }
            }
        }
    }

    public static boolean isArmStrongNumber (long number, long N) {
        long result = 0;
        String snumber = String.valueOf(number);
        int len = snumber.length();
        int curDig;
        long numberSource = number;
        if (number == 0 || len > String.valueOf(N).length()) return false;
        while (numberSource > 0) {
            //curDig = (int)snumber.charAt(i)-'0';
            curDig = (int) (numberSource % 10);
            numberSource /= 10;

            result += degreeTable[curDig][len];
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

        long startTime = System.nanoTime();
        long result [] = getNumbers(55);
        for (long l : result) {
            System.out.println(l);
        }

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        System.out.println(duration/1000000 +" msec");
        System.out.println("amount: " + result.length);
       // System.out.println(isArmStrongNumber(4929273885928088826L, String.valueOf(Long.MAX_VALUE).length()));
    }
}
