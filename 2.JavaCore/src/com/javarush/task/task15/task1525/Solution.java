package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {


    public static List<String> lines = new ArrayList<String>();
    static {

        try {
            String line;
            BufferedReader r = new BufferedReader(new FileReader(Statics.FILE_NAME));
            while ((line = r.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
