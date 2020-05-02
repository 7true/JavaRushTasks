package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager extends Thread implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {

    }

    @Override
    public void update(Observable observable, Object o) {
        Order order = (Order) o;
        try {
            orderQueue.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
