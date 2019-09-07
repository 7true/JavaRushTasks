package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

import java.text.SimpleDateFormat;

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T> {
        SimpleObject<String> getInstance();
    }

    static class StringObject <String> implements SimpleObject {

        @Override
        public SimpleObject getInstance() {
            return null;
        }
    }

}
