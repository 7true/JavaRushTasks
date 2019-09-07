package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.javarush.task.task14.task1411.Person.*;
/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        //тут цикл по чтению ключей, пункт 1
        while (!(key = reader.readLine()).isEmpty())
        {
            if ((!key.equals("user")) && (!key.equals("loser")) && (!key.equals("coder")) &&(!key.equals("proger")))
                break;
            //создаем объект, пункт 2
            if (key.equals("user"))
                person = new User();
            if (key.equals("loser"))
                person = new Loser();
            if (key.equals("coder"))
                person = new Coder();
            if (key.equals("proger"))
                person = new Proger();
            doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof User) {
           ((User) person).live();
        }
        if (person instanceof Loser) {
            ((Loser) person).doNothing();
        }
        if (person instanceof Coder) {
            ((Coder) person).writeCode();
        }
        if (person instanceof Proger) {
            ((Proger) person).enjoy();
        }
    }
}
