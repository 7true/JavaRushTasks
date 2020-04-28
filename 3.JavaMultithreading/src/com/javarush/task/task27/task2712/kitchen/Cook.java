package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook  extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object o) {
        Tablet tablet = (Tablet)observable;
        Order order = (Order) o;
        ConsoleHelper.writeMessage("Start cooking - " + o +", cooking time " + ((Order) o).getTotalCookingTime() + "min");
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(tablet.toString(),
                this.name, order.getTotalCookingTime()*60, order.getDishes()));
        setChanged();
        notifyObservers(o);
    }
}
