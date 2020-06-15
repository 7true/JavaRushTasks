package com.javarush.task.task31.task3113;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution  extends SimpleFileVisitor<Path>{
    private static int folderCount;
    private static int filesCount;
    private static int fullSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String folder = br.readLine();
        Path path = Paths.get(folder);

        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
            return;
        }

        FileVisitor<Path>simpleFileVisitor = new Solution();

        Files.walkFileTree(path, simpleFileVisitor);
        System.out.println("Всего папок - " + (folderCount - 1));
        System.out.println("Всего файлов - " + filesCount);
        System.out.println("Общий размер  - " + fullSize);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        folderCount++;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        filesCount++;
        fullSize += Files.size(file);
        return super.visitFile(file, attrs);
    }
}
