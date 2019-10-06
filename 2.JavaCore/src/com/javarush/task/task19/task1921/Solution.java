package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws ParseException {
        ArrayList<String> fileContent = new ArrayList<>();
        //Map<String,Double> result = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))){
            while (br.ready()) {
                fileContent.add(br.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < fileContent.size(); i++) {
            String currentString = fileContent.get(i);
          /*  String[] arrCurrent = currentString.split("\\s\\d", 2);
           // System.out.println(arrCurrent[0]+ "#" + arrCurrent[1]);
            DateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date date = format.parse(arrCurrent[1].trim());*/
            String name = currentString.replaceAll("\\d", "").trim();
            String date = currentString.replace(name, "").trim();
            DateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            PEOPLE.add(new Person(name, format.parse(date)));
        }
        for (Person p : PEOPLE) {
            System.out.println(p.getName() + " " + p.getBirthDate());
        }
    }
}
