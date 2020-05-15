package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        if (x == 0) {
            return "";
        }
        BinaryRepresentationTask task = new BinaryRepresentationTask(b);
        if (b > 0) {
            task.fork();
            return task.join() + a;
        } else {
            return String.valueOf(a);
        }
    }
}
