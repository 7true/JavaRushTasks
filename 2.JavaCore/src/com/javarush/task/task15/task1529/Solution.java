package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static CanFly result;
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static void main(String[] args) {

    }

    public static void reset() {
        //add your code here - добавьте код тут
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String p = r.readLine();
            if (p.equals("helicopter")) {
                result = new Helicopter();
            }
            else if (p.equals("plane")){
                p = r.readLine();
                int passCount = Integer.parseInt(p);
                result = new Plane(passCount);
            }
            r.close();
        }
        catch (Exception e) {

        }
    }
}
