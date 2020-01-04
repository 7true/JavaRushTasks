package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final double median;
        if (array.length % 2 == 0) {
            median = ((double) array[array.length / 2 - 1] + (double) array[array.length / 2]) / 2;
        } else {
            median = array[array.length / 2];
        }
        List<Integer> list = Arrays.asList(array);
        list.sort(Comparator.comparing(o -> Math.abs((int) median - o)));
        return (Integer[]) list.toArray();
    }
}
