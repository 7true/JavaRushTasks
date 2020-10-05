package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public static void recurse(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i);
                if (n != i) {
                    System.out.print(" ");
                }
                recurse(n/i);
                break;
            }
        }
    }
    public static void main(String[] args) {
        recurse(221);
    }
}
