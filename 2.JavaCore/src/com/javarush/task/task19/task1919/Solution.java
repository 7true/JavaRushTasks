package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
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
            String [] arrCurrent = currentString.split("\\s", 2);
            Double currentSal = Double.parseDouble(arrCurrent[1]);
            for (int j = i + 1; j < fileContent.size(); j++) {
                String nextString = fileContent.get(j);
                String[] arrNext = nextString.split("\\s", 2);
                Double nextSal = Double.parseDouble(arrNext[1]);
                if (arrCurrent[0].equals(arrNext[0])) {
                    currentSal += nextSal;
                }
            }
            if (!result.containsKey(arrCurrent[0]))
                result.put(arrCurrent[0], currentSal);
        }
        for (Map.Entry<String, Double> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
