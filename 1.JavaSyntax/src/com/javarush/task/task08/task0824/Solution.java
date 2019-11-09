package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> chListEmpty = new ArrayList<>();
        Human ch1 = new Human("р1", true, 1, chListEmpty);
        Human ch2 = new Human("р2", true, 2, chListEmpty);
        Human ch3 = new Human("р3", false, 3, chListEmpty);
        ArrayList<Human> children = new ArrayList<>();
        children.add(ch1);
        children.add(ch2);
        children.add(ch3);
        Human f1 = new Human("п", true, 35, children);
        Human m1 = new Human("м", false, 35, children);
        ArrayList<Human> childrenMiddle1 = new ArrayList<>();
        ArrayList<Human> childrenMiddle2 = new ArrayList<>();
        childrenMiddle1.add(f1);
        childrenMiddle2.add(m1);
        Human gf1 = new Human("д1", true, 78, childrenMiddle1);
        Human gf2 = new Human("д2", true, 79, childrenMiddle2);

        Human gm1 = new Human("б1", false, 78, childrenMiddle1);
        Human gm2 = new Human("б2", false, 79, childrenMiddle2);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println(f1);
        System.out.println(m1);
        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gm1);
        System.out.println(gm2);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
