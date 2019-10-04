package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            br.close();

            BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader br2 = new BufferedReader(new FileReader(fileName2));

            Stack<String> file1 = new Stack<>();
            Stack<String> file2 = new Stack<>();

            while (br1.ready()) {
                file1.push(br1.readLine());
            }

            while (br2.ready()) {
                file2.push(br2.readLine());
            }

            Collections.reverse(file1);
            Collections.reverse(file2);

            String s1, s2, next;
            for(; file1.size () > 1 || file2.size() > 1;) {
                s1 = file1.pop();
                s2 = file2.pop();

                if (s1.equals(s2)) {
                    lines.add(new LineItem(Type.SAME,s1));
                }
                else {
                    next = file1.pop();
                    if (next.equals(s2)) {
                        lines.add(new LineItem(Type.REMOVED, s1));
                        lines.add(new LineItem(Type.SAME,next));
                    }
                    else {
                        file1.push(next);
                        next = file2.pop();
                        if (next.equals(s1)) {
                            lines.add(new LineItem(Type.ADDED, s2));
                            lines.add(new LineItem(Type.SAME, next));
                        }
                    }
                }

                if (file1.size() > 0 && file2.size() == 0) {
                    while (file1.size () > 0)
                        lines.add(new LineItem(Type.REMOVED, file1.pop()));
                }

                if (file1.size() == 0 && file2.size() > 0) {
                    while (file2.size () > 0)
                        lines.add(new LineItem(Type.ADDED, file2.pop()));
                }

                br1.close();
                br2.close();
                //System.out.println(file1.pop());
            }
            //ArrayList<String> lines = new ArrayList();
            /*Iterator<LineItem> lIt = lines.iterator();
            while (lIt.hasNext()) {
                LineItem current = lIt.next();
                System.out.println(current.type + " " + current.line);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static enum Type {
        ADDED, //добавлена новая строка
        REMOVED, //удалена строка
        SAME //без изменений
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