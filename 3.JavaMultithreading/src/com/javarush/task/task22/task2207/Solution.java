package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        List<String> workArray = new ArrayList<>();
        String line;
        BufferedReader r = new BufferedReader(new FileReader(fileName));
        while ((line = r.readLine()) != null) {
            String[] lines = line.split(" ");
            for (int i = 0; i < lines.length; ++i) {
                workArray.add(lines[i]);
            }
        }

        for (int i = 0; i < workArray.size(); ++i) {
            String current = workArray.get(i);
            for (int j = i + 1; j < workArray.size(); ++j) {
                StringBuilder sNext = new StringBuilder(workArray.get(j));
                sNext.reverse();
                if (sNext.toString().equals(current)) {
                    Pair p = new Pair(current, sNext.reverse().toString());
                    result.add(p);
                    workArray.remove(j);
                }
            }
        }

        for (Pair p:result) {
            System.out.println(p);
        }

        r.close();
        br.close();
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
