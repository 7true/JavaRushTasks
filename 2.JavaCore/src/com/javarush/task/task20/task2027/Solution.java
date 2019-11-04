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
        List<Word> words = detectAllWords(crossword, "home", "same");
        for (Word w : words) {
            System.out.println(w);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    static Word searchWord(int[][] grid, int row,
                            int col, String word) {
        int R, C, eR = 0, eC = 0;
        int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
        R = grid.length;
        C = grid[0].length;
        if (grid[row][col] != word.charAt(0))
            return null;

        int len = word.length();

        for (int dir = 0; dir < 8; dir++) {
            int k, rd = row + x[dir], cd = col + y[dir];

            for (k = 1; k < len; k++) {
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;
                if (grid[rd][cd] != word.charAt(k))
                    break;
                eR = rd;
                eC = cd;
                rd += x[dir];
                cd += y[dir];

            }

            // word found!
            if (k == len) {
                Word w = new Word(word);
                w.setStartPoint(col, row);
                w.setEndPoint(eC, eR);
                return w;
            }
        }
        return null;
    }

    static Word patternSearch(int[][] grid, String word) {
        Word w;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                w = searchWord(grid, row, col, word);
                if (w != null) {
                    return w;
                }
            }
        }
        return null;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Word w = patternSearch(crossword, words[i]);
            if (w != null)
                wordList.add(w);
        }
        return wordList;
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
