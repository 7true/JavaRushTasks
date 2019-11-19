package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fws = new FileOutputStream(args[1]);
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(fis, 200);
        //BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fws, 200);
        Charset utf_8 = Charset.forName("UTF-8");
        Charset win_1251 = Charset.forName("Windows-1251");

        byte[] buffer = new byte[1];

        while ((fis.read(buffer)) != -1) {
            String bufString = new String(buffer, win_1251);
            byte[] bufferW;
            bufferW = bufString.getBytes(utf_8);
            fws.write(bufferW);
        }


        fis.close();
        fws.close();
//        bufferedInputStream.close();
//        bufferedOutputStream.close();
    }
}
