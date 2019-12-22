package com.javarush.task.task25.task2505;

import java.sql.SQLOutput;

/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            //setDaemon(true);

        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }


        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String out = String.format("%s, %s, %s", secretKey, thread.getName(), throwable.getMessage());
                System.out.println(out);
            }
        }

    }

}

