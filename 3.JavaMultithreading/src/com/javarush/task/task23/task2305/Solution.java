package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static Solution[] getTwoSolutions() {
        Solution s1 = new Solution();
        Solution s2 = new Solution();
        s1.innerClasses[0] = new InnerClass();
        s1.innerClasses[1] = new InnerClass();
        s2.innerClasses[0] = new InnerClass();
        s2.innerClasses[1] = new InnerClass();
        Solution[] result = new Solution[2];
        result[0] = s1;
        result[1] = s2;
        return result;
    }

    public static void main(String[] args) {

    }

    public static class InnerClass {
    }
}
