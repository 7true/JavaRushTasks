package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md5hash = MessageDigest.getInstance("MD5");
        byte[] digest = md5hash.digest(byteArrayOutputStream.toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b :digest) {
            sb.append(String.format("%02X", b));
        }
        if (sb.toString().toLowerCase().equals(md5)) {
            return true;
        } else {
            return false;
        }
    }
}
