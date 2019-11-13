package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main (String[] args) throws InterruptedException {

        List <Horse> horses = new ArrayList<>();
        horses.add(new Horse("Gorbunok", 3, 0));
        horses.add(new Horse("Sivka", 3, 0));
        horses.add(new Horse("Mustang", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; ++i) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        int i = 0;
        while (i < 10) {
            System.out.println();
            ++i;
        }
    }

    public Horse getWinner() {
        int indexWinner = 0;
        double maxDistance = 0;
        for (int i = 0; i < this.horses.size(); ++i) {
            if (this.horses.get(i).getDistance() >= maxDistance) {
                indexWinner = i;
                maxDistance = this.horses.get(i).getDistance();
            }
        }
        return this.horses.get(indexWinner);
    }

    public void printWinner() {
        Horse h = getWinner();
        System.out.println("Winner is " + h.getName() + "!");
    }
}
