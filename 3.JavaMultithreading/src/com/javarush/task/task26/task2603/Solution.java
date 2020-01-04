package com.javarush.task.task26.task2603;

import java.util.Arrays;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T> [] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }
        @Override
        public int compare(T t, T t1) {
            int result = 0;
            for (Comparator comparator : comparators) {
                result = comparator.compare(t, t1);
                if (result != 0) {
                    break;
                }
            }
            return result;
        }
    }

}
