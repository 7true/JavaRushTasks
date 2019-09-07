package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        List<String> argsList = new ArrayList<>(Arrays.asList(args));
        //argsList = Arrays.asList(args);
        while (argsList.size() > 1) {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        if (argsList.get(2).equals("м")) {
                            try {
                                allPeople.add(Person.createMale(argsList.get(1), new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(argsList.get(3))));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } else if (argsList.get(2).equals("ж"))
                            try {
                                allPeople.add(Person.createFemale(argsList.get(1), new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(argsList.get(3))));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        System.out.println(allPeople.size() - 1);
                        for (int i = 0; i < 3; i++)
                            argsList.remove(1);
                        //argsList.add(0,"-c");
                        break;
                    }
                case "-u":
                    synchronized (allPeople) {
                        int id = Integer.parseInt(argsList.get(1));
                        Person thisPerson;
                        if (id < allPeople.size() && id >= 0) {
                            thisPerson = allPeople.get(id);
                            thisPerson.setName(argsList.get(2));
                            if (argsList.get(3) == "м") {
                                thisPerson.setSex(Sex.MALE);
                            } else thisPerson.setSex(Sex.FEMALE);

                            try {
                                thisPerson.setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(argsList.get(4)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < 4; i++)
                            argsList.remove(1);
                        break;
                    }
                case "-d":
                    synchronized (allPeople) {
                        int id = Integer.parseInt(argsList.get(1));
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setBirthDate(null);
                        allPeople.get(id).setSex(null);
                        argsList.remove(1);
                        break;
                    }
                case "-i":
                    synchronized (allPeople) {
                        int id = Integer.parseInt(argsList.get(1));
                        Person thisPerson;
                        if (id < allPeople.size() && id >= 0) {
                            thisPerson = allPeople.get(id);
                            System.out.println(thisPerson.getName() + " " + (thisPerson.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(thisPerson.getBirthDate()));
                        }
                        argsList.remove(1);
                        break;
                    }
            }
        }

    }
}
