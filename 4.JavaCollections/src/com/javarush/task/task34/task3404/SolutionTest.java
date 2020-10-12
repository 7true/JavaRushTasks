package com.javarush.task.task34.task3404;

class SolutionTest {
    static Solution solution = new Solution();
    public static void main(String[] args) {
        solution.recurse("tan(45)", 0);System.out.println("1 1 - expected output");
        solution.recurse("tan(-45)", 0);System.out.println("-1 2 - expected output");
        solution.recurse("0.305", 0);System.out.println("0.3 0 - expected output");
        solution.recurse("0.3051", 0);System.out.println("0.31 - expected output");
    }
}