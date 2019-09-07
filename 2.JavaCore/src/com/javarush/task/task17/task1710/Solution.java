package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                if (args[2].equals("м") && args.length == 4) {
                    try {
                        allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                else if (args[2].equals("ж") && args.length == 4)
                    try {
                        allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                System.out.println(allPeople.size()-1);
                break;
            case  "-u":
                int id = Integer.parseInt(args[1]);
                Person thisPerson;
                if (id < allPeople.size() && id >= 0 && args.length == 5) {
                    thisPerson = allPeople.get(id);
                    thisPerson.setName(args[2]);
                    if (args[3] == "м") {
                        thisPerson.setSex(Sex.MALE);
                    }
                    else thisPerson.setSex(Sex.FEMALE);

                    try {
                        thisPerson.setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case "-d":
                if (args.length == 2) {
                    id = Integer.parseInt(args[1]);
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setBirthDate(null);
                    allPeople.get(id).setSex(null);
                    //allPeople.remove(id);
                }
                break;

            case "-i":
                id = Integer.parseInt(args[1]);

                if (args.length == 2 && id < allPeople.size() && id >= 0) {
                    thisPerson = allPeople.get(id);
                    System.out.println(thisPerson.getName() + " " + (thisPerson.getSex().equals(Sex.MALE)?"м":"ж") + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(thisPerson.getBirthDate()));
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + args[0]);
        }
    }
}
