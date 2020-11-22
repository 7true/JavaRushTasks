package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        char[] arr = s.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = map.get(arr[arr.length - 1]);
        int j;
        boolean add;
        for (int i = arr.length - 2; i >= 0; i--) {
            add = false;

            if (map.get(arr[i]) >= map.get(arr[i + 1])) {
                add = true;
            }

            if (add) {
                result += map.get(arr[i]);
            } else {
                result -= map.get(arr[i]);
            }
        }
        return result;
    }
}
