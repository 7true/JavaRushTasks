package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized static void main(String[] args) {

    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach beach) {
        int quality = this.getQuality() > beach.getQuality() ? 1 : -1;
        int distance = this.getDistance() < beach.getDistance() ? 2 :-2;
        int result = quality + distance;
        if (this.getQuality() == beach.getQuality() && this.getDistance() == beach.getDistance())
            result = 0;
        return result;
    }
}
