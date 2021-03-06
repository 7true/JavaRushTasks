package com.javarush.task.task27.task2709;

public class TransferObject {
    protected volatile boolean isValuePresent = false; //use this variable
    private int value;

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isValuePresent = false;
        notifyAll();
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        notifyAll();
    }
}
