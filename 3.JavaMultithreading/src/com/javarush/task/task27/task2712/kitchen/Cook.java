package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook  extends Observable implements Runnable {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public Cook(String name, LinkedBlockingQueue<Order> orderQueue) {
        this.name = name;
        this.setOrderQueue(orderQueue);
    }

    public void setOrderQueue(LinkedBlockingQueue<Order> orderQueue) {
        this.orderQueue = orderQueue;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) throws InterruptedException {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order +", cooking time " + order.getTotalCookingTime() + "min");
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),
                this.name, order.getTotalCookingTime()*60, order.getDishes()));
        setChanged();
        notifyObservers(order);
        Thread.sleep(order.getTotalCookingTime() * 10);
        busy = false;
    }

    @Override
    public void run() {
        Thread daemonTread = new Thread(new Runnable() {
            @Override
            public void run() {
                Set<Cook> cooks = StatisticManager.getInstance().getCooks();
                while (true) {
                    if (!orderQueue.isEmpty()) {
                        for (Cook cook : cooks) {
                            if (!cook.isBusy()) {
                                try {
                                    cook.startCookingOrder(orderQueue.poll());
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        daemonTread.setDaemon(true);
        daemonTread.start();
    }
}
