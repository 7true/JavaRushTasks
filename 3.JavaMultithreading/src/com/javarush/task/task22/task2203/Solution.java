package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int indexFrom = string.indexOf("\t") + 1;
            String tmp = string.substring(indexFrom);
            int indexEnd = tmp.indexOf("\t");
            return tmp.substring(0, indexEnd);
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший"));
    }

    public static class TooShortStringException extends Exception {
    }
}
