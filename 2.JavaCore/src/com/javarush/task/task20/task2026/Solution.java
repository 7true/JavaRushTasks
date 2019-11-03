package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int i = 0;i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    count++;
                    int rightEdge = i;
                    int downEdge = j;
                    for (int k = i; k < a.length; k++) {
                        if (a[k][j] == 0) {
                            rightEdge = k - 1;
                            break;
                        }
                        else if (k == a.length - 1) {
                            rightEdge = a.length - 1;
                        }
                    }
                    for (int d = j; d < a.length; d++) {
                        if (a[rightEdge][d] == 0) {
                            downEdge = d - 1;
                            break;
                        }
                        else if (d == a.length - 1) {
                            downEdge = a.length - 1;
                        }
                    }

                    for (int x = i;x <= rightEdge; x++) {
                        for (int y = j; y <= downEdge; y++) {
                            a[x][y] = 0;
                        }
                    }

                }
            }
        }
        for (int i = 0;i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return count;
    }
}
