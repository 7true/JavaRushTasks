package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        ArrayList<String> fileContent = new ArrayList<>();
        Map<String,Double> result = new TreeMap<>();
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
            String[] arrCurrent = currentString.split("\\s\\d", 2);

        }
    }
}
