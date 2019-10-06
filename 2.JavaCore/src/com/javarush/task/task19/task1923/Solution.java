package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String[]> fileContent = new ArrayList<>();
        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fr = new BufferedReader(new FileReader(args[0]));
            BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));

            while (fr.ready()) {
                fileContent.add(fr.readLine().split("\\s"));
            }

            String result="";
            for (String s[] : fileContent) {
                for (int i = 0; i < s.length; i++) {
                    if (s[i].matches(".*\\d.*")) {
                        result = result + s[i] + " ";
                    }
                }
            }

            out.write(result.trim());

            fr.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
