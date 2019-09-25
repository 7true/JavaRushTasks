package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner sc) {
            this.fileScanner = sc;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String[] personArr = line.split("\\s", 4);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("d M y", Locale.ENGLISH).parse(personArr[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(personArr[1], personArr[2], personArr[0],birthDate);
         }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
