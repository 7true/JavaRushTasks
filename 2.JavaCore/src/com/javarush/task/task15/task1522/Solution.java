package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void main(String[] args) {

    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String line = r.readLine();
            switch (line) {
                case Planet.EARTH:
                    thePlanet = Earth.getInstance();
                    break;
                case Planet.MOON:
                    thePlanet = Moon.getInstance();
                    break;
                case Planet.SUN:
                    thePlanet = Sun.getInstance();
                    break;
                default:
                    thePlanet = null;
            }
            r.close();
        }
        catch (Exception e) {

        }
    }
}
