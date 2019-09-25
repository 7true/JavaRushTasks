package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fout) {
         fileOutputStream = fout;
    }
    public static void main(String[] args) {

    }


    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] b = s.getBytes(Charset.forName("UTF-8"));
        fileOutputStream.write(b);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}

