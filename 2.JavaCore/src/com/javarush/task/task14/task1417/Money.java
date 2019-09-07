package com.javarush.task.task14.task1417;

public abstract class Money {

    private double amount;

    public Money(double a) {
        this.amount = a;
    }

    //public abstract double getAmount();

    public abstract String getCurrencyName();

    public double getAmount() {
        return this.amount;
    }
}

