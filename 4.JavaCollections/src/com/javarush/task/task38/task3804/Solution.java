package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
        Exception e = (Exception) ExceptionFactory.createException(ApplicationExceptionMessage.SOCKET_IS_CLOSED);
        System.out.println(e.getMessage());
    }
}