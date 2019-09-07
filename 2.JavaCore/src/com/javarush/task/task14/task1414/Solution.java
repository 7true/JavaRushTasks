package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;
        ArrayList <String> keys = new ArrayList<>();
        while (!(key = reader.readLine()).isEmpty()) {
            keys.add(key);
            if ((!key.equals("cartoon")) && (!key.equals("thriller")) && (!key.equals("soapOpera")))
                break;
        }

        for (String s : keys) {
            if ((!s.equals("cartoon")) && (!s.equals("thriller")) && (!s.equals("soapOpera"))) {
                Movie movie = MovieFactory.getMovie(s); break;}
            Movie movie = MovieFactory.getMovie(s);
            System.out.println(movie.getClass().getSimpleName());
        }


    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            //напишите тут ваш код, пункты 5,6
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3
    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}
