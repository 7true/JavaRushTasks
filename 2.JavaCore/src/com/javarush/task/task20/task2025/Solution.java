package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long degreeTable[][];
    private static List<Long> sorted = new ArrayList<>();

    public static long[] getNumbers(long N) {
        sorted.clear();
        Set<Long> res = new TreeSet<>();

        int lengthN = String.valueOf(N).length();
        int[] digits = new int[lengthN];
        long n = N;
        for (int i = lengthN-1; n > 0 ; i--) {
            long digit = n % 10;
            digits[i] = (int) digit;
            n /= 10;
            //System.out.println(digits[i]);
        }

        degreeTable = getPower(lengthN);
/*
* generate Matrix like
* 9
* 9 9
* 9 9 9 9
* 9 9 9 9 9
* our  number
* */
        int[][] genTable = genTableMax(digits);
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(genTable[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < lengthN; i++) {
            generateSeq(genTable[i], );
        }


        for (long l : sorted) {
            System.out.println(l);
            Long result;
            int len = getDigitsCount(l);
            result = eval(l, len);
            if (isArmStrongNumber(result) && result <= N) {
                res.add(result);
            }

        }
        System.out.println(sorted.size());
        long[] result = new long[res.size()];
        int c = 0;
        for (Long l : res) {
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
    private static long[][] getPower(int num) {
        long[][] result = new long[10][++num];
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < num; j++) {
                result[i][j] = longPower(i, j);
            }
        }
        return result;
    }

    private static long eval(long number, int pow) {
        long temp = 0;
        while (number > 0) {
            temp += degreeTable[(int) (number % 10)][pow - 1];
            number /= 10;
        }
        return temp;
    }

    private static long longPower(int num, int power) {
        long result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }

    public static void generateSeq (int start, long N, String value){
        /*String n = String.valueOf(N);
        for (int i = start; i <= 9; i++) {
            if (i >= start && value.length() <= n.length() ) {
                value = value.substring(0, value.length() - 1) + i;
                if (Long.valueOf(value) > N) {
                    return;
                }
                try {

                    sorted.add(Long.valueOf(value));

                }
                catch (Exception e) {
                    return;
                }
                generateSeq(i+1, N, value);

                if (value.length() == n.length()-1 || value.charAt(value.length() - 1) == '9') {
                    String valueZeroEnd = value.substring(0, value.length() - 1) + "0";
                    sorted.add(Long.valueOf(valueZeroEnd));

                    if (value.charAt(value.length() - 1) == '9') {
                        int len =  valueZeroEnd.length();
                        for (int j = 0;j < n.length()- len;j++) {
                            if (valueZeroEnd.length() < String.valueOf(Long.MAX_VALUE).length()) {
                                try {
                                    valueZeroEnd = valueZeroEnd + "0";
                                    if (Long.valueOf(valueZeroEnd) > N) {
                                        return;
                                    }
                                    sorted.add((Long.valueOf(valueZeroEnd)));
                                }
                                catch (Exception e) {
                                    return;
                                }
                            }
                        }
                    }
                }
                value = value + i;
                if (Long.valueOf(value) > N) {
                    return;
                }
                generateSeq(i, N, value);
            }

        }
*/

    }
    private static long pow(long num, int power) {
        long temp = 1;
        for (int i = 0; i < power; i++){
            temp *= num;
        }
        return temp;
    }

    private static int getDigitsCount(long n){
        int count = 0;
        while (n > 0){
            count++;
            n /= 10;
        }
        return count;
    }

    public static boolean isArmStrongNumber (long number) {
        long result = 0;
        String snumber = String.valueOf(number);
        int len = snumber.length();
        long curDig;
        if (number == 0) return false;
        for (int i = 0; i < len; i++) {
            curDig = (long)snumber.charAt(i)-'0';
            result += degreeTable[(int)curDig][len];
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
        long result [] = getNumbers(1562);
        for (long l : result) {
            System.out.println(l);
        }

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(degreeTable[i][j] + " ");
//            }
//            System.out.println();
//        }

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println(duration/1000000 +" msec");
    }
}