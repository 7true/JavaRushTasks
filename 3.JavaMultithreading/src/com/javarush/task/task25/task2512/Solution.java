package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        List<String> list  = new ArrayList<>();
        t.interrupt();
        recursion(list, e);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void recursion( List<String> l , Throwable e) {
        if (e != null ) {
            recursion(l, e.getCause());
            l.add(e.toString());
        }
    }
}
