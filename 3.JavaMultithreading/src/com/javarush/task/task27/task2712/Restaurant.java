package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    public static void main(String[] args) throws ParseException {
        Cook cook = new Cook("Amigo");
        cook.setQueue(orderQueue);
        Cook cook2 = new Cook("Sanya");
        cook2.setQueue(orderQueue);

        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);
//        StatisticManager.getInstance().register(cook);
//        StatisticManager.getInstance().register(cook2);
        Thread cookThread = new Thread(cook);
        Thread cookThread2 = new Thread(cook2);
        cookThread.start();
        cookThread2.start();

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tabletList.add(tablet);

        }

        DirectorTablet dirTablet = new DirectorTablet();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }

        thread.interrupt();
        dirTablet.printAdvertisementProfit();
        dirTablet.printCookWorkloading();
        dirTablet.printActiveVideoSet();
        dirTablet.printArchivedVideoSet();

    }
}
