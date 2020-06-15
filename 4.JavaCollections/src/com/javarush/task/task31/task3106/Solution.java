package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(args[0]);
        ArrayList<FileInputStream> argsList = new ArrayList<>();
        Arrays.sort(args, 1, args.length);
        for (int i = 1; i < args.length; ++i) {
            argsList.add(new FileInputStream(args[i]));
        }
        ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(argsList)));
        ZipEntry entry;
        byte[] buffer = new byte[1024 * 1024];
        while ((entry = zis.getNextEntry()) != null) {
            int byteBuffer;
            while ((byteBuffer = zis.read(buffer)) != -1) {
                fos.write(buffer, 0, byteBuffer);
            }
            zis.closeEntry();
        }
        fos.close();
        zis.close();
    }
}
