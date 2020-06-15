package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootPath = new File(root);
        List<String> files = new ArrayList<>();
        Queue<File>fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, rootPath.listFiles());

        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                files.add(currentFile.getAbsolutePath());
            }
        }
        return files;

    }

    public static void main(String[] args) {

    }
}
