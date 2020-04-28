package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        int countRandomDish = (int)(1 + (Math.random() * Dish.values().length));
        dishes = new ArrayList<>();
        while (countRandomDish > 0) {
            int indexRandom = (int)(Math.random() * Dish.values().length);
            dishes.add(Dish.values()[indexRandom]);
            countRandomDish--;
        }
    }
}
