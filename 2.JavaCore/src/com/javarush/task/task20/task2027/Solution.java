package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList <String> arrWordsHorizont = new ArrayList();
        ArrayList <String> arrWordsVertical = new ArrayList();
        ArrayList <String> arrWordsDiagDown = new ArrayList();
        ArrayList <String> arrWordsDiagUp = new ArrayList();
        StringBuilder sbH = new StringBuilder();
        StringBuilder sbV = new StringBuilder();
        StringBuilder sbD = new StringBuilder();
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                sbH.append((char)crossword[i][j]);
            }
            arrWordsHorizont.add(sbH.toString());
            sbH.delete(0, sbH.length());
            for (int k = 0; k < crossword.length; k++) {
                sbV.append((char) crossword[k][i]);
            }
            arrWordsVertical.add(sbV.toString());
            sbV.delete(0, sbV.length());
            for (int r = 0; i + r < crossword.length; r++) {
                sbD.append((char) crossword[i+r][r]);
            }
            arrWordsDiagDown.add(sbD.toString());
            sbD.delete(0, sbD.length());
            for (int r = 0; i + r < crossword.length; r++) {
                sbD.append((char) crossword[r][i+r]);
            }
            arrWordsDiagDown.add(sbD.toString());
            sbD.delete(0, sbD.length());
        }

        for (String s : arrWordsHorizont) {
            System.out.println(s);
        }
        System.out.println("########");
        for (String s : arrWordsVertical) {
            System.out.println(s);
        }
        System.out.println("########");
        for (String s : arrWordsDiagDown) {
            System.out.println(s);
        }
        return null;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
