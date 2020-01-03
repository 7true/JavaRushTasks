package com.javarush.task.task29.task2909.human;

public class Worker extends Human {


    private String company;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}