package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) throws ParseException {
//        Tablet tablet = new Tablet(5);
//        tablet.createOrder();
        Cook cook = new Cook("Amigo");
        Cook cook2 = new Cook("Sanya");
        StatisticManager.getInstance().register(cook);
        StatisticManager.getInstance().register(cook2);
        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tabletList.add(tablet);
            tablet.addObserver(cook);
            tablet.addObserver(cook2);
        }
        Waiter waiter = new Waiter();

        cook.addObserver(waiter);
        cook2.addObserver(waiter);



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
