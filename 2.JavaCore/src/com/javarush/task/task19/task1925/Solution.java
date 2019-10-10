package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            ArrayList<String> fileContent = new ArrayList<>();
            while (br.ready()) {
                fileContent.add(br.readLine());
            }
            String result = "";
            BufferedWriter bwr = new BufferedWriter(new FileWriter(args[1]));
            for (int i = 0; i < fileContent.size(); i++) {
                String [] arr = fileContent.get(i).split("\\s");
                for (int j = 0; j < arr.length; j++) {
                    if ( arr[j].length() > 6) {
                        result = result + arr[j] + ",";
                    }
                }
            }
            result = result.substring(0, result.length()-1);
            bwr.write(result);
            br.close();
            bwr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
