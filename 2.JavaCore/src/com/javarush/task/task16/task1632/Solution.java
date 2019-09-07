package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new Thread1()));
        threads.add(new Thread(new Thread2()));
        threads.add(new Thread(new Thread3()));
        threads.add(new Thread4());
        threads.add(new Thread(new Thread5()));
    }

    public static void main(String[] args) {

    }

    public static class Thread1 implements Runnable {

        @Override
        public void run() {
            while(true) {

            }
        }
    }

    public static class Thread2 implements Runnable {

        @Override
        public void run() {
            try {
                while(true) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        boolean run = true;
        @Override
        public void run() {
            while (run) {
            }
        }

        @Override
        public void showWarning() {
            this.run = false;
        }
    }

    public static class Thread5 implements Runnable {

        @Override
        public void run() {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            ArrayList <Integer> numbers = new ArrayList<>();

            try {
                String s = "";
                while (!Thread.currentThread().isInterrupted() && !(s = r.readLine()).equals("N"))
                    numbers.add(Integer.parseInt(s));
                Integer sum = 0;
                for (Integer i : numbers) {
                    sum += i;
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}