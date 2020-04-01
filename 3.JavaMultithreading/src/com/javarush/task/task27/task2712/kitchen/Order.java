package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) {
            return "";
        }
        String stringOrder = "Your order: [";
        for (Dish d : dishes) {
            stringOrder = stringOrder + d.toString() + ", ";
        }
        stringOrder = stringOrder.trim().substring(0, stringOrder.length() - 1);
        stringOrder = stringOrder + "] of " + tablet;

        return stringOrder;
    }
}
