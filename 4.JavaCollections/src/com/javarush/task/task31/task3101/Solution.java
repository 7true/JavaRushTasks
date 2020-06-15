package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File destination = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileInputStream fin;
        FileOutputStream fos = new FileOutputStream(destination, true);
        Map<String, String> map = new TreeMap<>();
        Queue<File> fileTree = new PriorityQueue<>();

        FileUtils.renameFile(resultFileAbsolutePath, destination);
        Collections.addAll(fileTree, path.listFiles());

        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileTree, currentFile.listFiles());
            } else if (currentFile.length() <= 50){
                map.put(currentFile.getName(), currentFile.getAbsolutePath());
            }
        }

        for (Map.Entry<String, String> value : map.entrySet()) {
            fin = new FileInputStream(value.getValue());
            byte[] buff = new byte[fin.available()];
            fin.read(buff);
            fos.write(buff);
            fos.write("\n".getBytes());
            fin.close();
        }
        fos.close();
    }
}
