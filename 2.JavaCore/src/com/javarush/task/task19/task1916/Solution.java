package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = br.readLine();
            String fileName2 = br.readLine();

            BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader br2 = new BufferedReader(new FileReader(fileName2));

            Stack<String> file1 = new Stack<>();
            Stack<String> file2 = new Stack<>();

            while (br1.ready()) {
                file1.push(br.readLine());
            }

            while (br2.ready()) {
                file2.push(br.readLine());
            }
            ArrayList<String> lines = new ArrayList();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
