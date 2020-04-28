package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private final int number;
    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
        return order;
    }


    public void createTestOrder() {
        TestOrder order = null;
        try {
            order = new TestOrder(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void processOrder(Order order) {
        if (!order.isEmpty()) {
            ConsoleHelper.writeMessage(order.toString());
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime()));
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            try {
                advertisementManager.processVideos();
            } catch (NoVideoAvailableException noVideo) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
            setChanged();
            notifyObservers(order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" + "number=" + number +"}";
    }
}
