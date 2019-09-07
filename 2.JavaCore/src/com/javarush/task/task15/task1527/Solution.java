package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IllegalFormatException;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        try {
            BufferedReader r  = new BufferedReader(new InputStreamReader(System.in));
            String url = r.readLine();
            ArrayList<String> params = new ArrayList<>();
            String paramString = url.substring(url.indexOf("?"));
            //System.out.println(paramString);
            while (paramString.contains("=")) {
                if (!paramString.contains("&")) {
                    params.add(paramString.substring(1));
                    break;
                }
                params.add(paramString.substring(paramString.lastIndexOf("&")+1));
                paramString = paramString.substring(0, paramString.lastIndexOf("&"));

            }
            Collections.reverse(params);
            for (String p : params) {
                if (p.contains("="))
                    System.out.println(p.substring(0,p.indexOf("=")));
                else
                    System.out.println(p);
            }
            for (String p : params) {
                if (p.contains("="))
                    if (p.substring(0, p.indexOf("=")).equals("obj")) {
                        try {
                            alert(Double.parseDouble(p.substring(p.indexOf("=") + 1)));
                        }
                        catch (NumberFormatException e) {
                            alert(p.substring(p.indexOf("=") + 1));
                        }
                    }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
