package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        Integer number;
       if (s.startsWith("0x")) {
           number = Integer.parseInt(s.substring(2), 16);
       } else if (s.startsWith("0") && !s.startsWith("08") && !s.startsWith("09") && !s.startsWith("0b")) {
           number = Integer.parseInt(s, 8);
       } else if (s.startsWith("0b")) {
           number = Integer.parseInt(s.substring(2), 2);
       } else {
           number = Integer.parseInt(s);
       }
        return String.valueOf(number);
    }
}
