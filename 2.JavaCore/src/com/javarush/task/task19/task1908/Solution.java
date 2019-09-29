package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileIn = br.readLine();
            String fileOut = br.readLine();

            FileReader reader = new FileReader(fileIn);
            FileWriter writer = new FileWriter(fileOut);
            BufferedReader brIn = new BufferedReader(reader);
            BufferedWriter brWr = new BufferedWriter(writer);

            String line = "";
            while (brIn.ready()) {
                int data = brIn.read();
                line = line + (char)data;
            }


            String[] arr = line.split("\\s");
            //System.out.println(line);
            if (arr.length == 0) {
                if (line.matches("\\d+"))
                    brWr.write(line);
            }

            for (int i = 0; i < arr.length; i++) {

                if (arr[i].matches("\\d++")) {
                    brWr.write(arr[i]);
                    if (i == arr.length - 1)
                        break;
                    brWr.write(" ");
                }
            }
            br.close();
            brIn.close();
            brWr.close();
            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
