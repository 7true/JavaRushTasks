package com.javarush.task.task27.task2712;

import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets = new ArrayList<>();
    private int interval;
    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            Tablet tablet = tablets.get((int)Math.random()*tablets.size());
            tablet.createOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}