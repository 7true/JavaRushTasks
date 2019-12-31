package com.javarush.task.task29.task2909.human;

public class Worker extends Human {
    public String company;
    //private Human human;
    private double salary;

    public Worker(String name, int age) {
        super(name, age);
    }

//
//    public Worker(String name, int age) {
//        human = new Human(name, age);
//    }

//    public void live() {
//        human.live();
//    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}