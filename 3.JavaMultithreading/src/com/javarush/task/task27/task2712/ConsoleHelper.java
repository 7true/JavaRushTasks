package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String line = null;
        line = bufferedReader.readLine();
        return line;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        ConsoleHelper.writeMessage("Список блюд для заказа:\n" +
                "Fish\n" +
                "Steak\n" +
                "Soup\n" +
                "Juice\n" +
                "Water\n");

        ConsoleHelper.writeMessage("Введите блюдо:");
        boolean isDishExists = false;
        String dish;
        while (!isDishExists) {
            dish = ConsoleHelper.readString();
            if (dish.equals("exit")) {
                break;
            }
            for (Dish d : Dish.values()) {
                if (d.name().equals(dish)) {
                    isDishExists = true;
                }
            }

            if (!isDishExists) {
                ConsoleHelper.writeMessage("Такого блюда нет, повторите ввод:");
            } else {
                dishes.add(Dish.valueOf(dish));
                isDishExists = false;
            }
        }
        return dishes;
    }
}
