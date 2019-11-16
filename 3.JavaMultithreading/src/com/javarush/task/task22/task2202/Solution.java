package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int indexFrom = string.indexOf(" ") + 1;
            int indexEnd = 0;
            int spaceCount = 0;
            char[] array = string.toCharArray();
            for (int j = 0; j < array.length; ++j) {
                if (array[j] == ' ') {
                    ++spaceCount;
                    if (spaceCount == 4) {
                        indexEnd = j;
                        for (int i = j; i < array.length; ++i) {
                            if (i == array.length - 1)
                                indexEnd = array.length;
                        }
                    }
                    if (spaceCount == 5) {
                        indexEnd = j;
                    }
                }

            }
            if (indexEnd != 0)
                return string.substring(indexFrom, indexEnd);
            else throw new TooShortStringException();
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }


    public static class TooShortStringException extends RuntimeException{
    }
}
