package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter target file path, please:");
            String pathArchive = bufferedReader.readLine();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(pathArchive));
            System.out.println("Enter source file path:");
            String pathFile = bufferedReader.readLine();
            zipFileManager.createZip(Paths.get(pathFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            new ExitCommand().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
