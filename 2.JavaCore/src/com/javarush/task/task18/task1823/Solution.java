package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while(true) {
            try {
                if ((fileName = br.readLine()).equals("exit")) {
                    br.close();
                    break;
                }
                Thread thr = new ReadThread(fileName);
                thr.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            super.run();
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ArrayList<Integer> aList = new ArrayList<>();
                while (fis.available()> 0) {
                    aList.add(fis.read());
                }

                Integer maxFreq = 1, current;
                Integer b = aList.get(0);
                for (int i : aList) {
                    current = Collections.frequency(aList, i);
                    if (current > maxFreq) {
                        maxFreq = current;
                        b = i;
                    }
                }

                resultMap.put(fileName, b);
                fis.close();
                System.out.println(fileName + " " + b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
