package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
            String line = "";
            while(fr.ready()) {
                line = line + (char)fr.read();
            }
            line = line.replaceAll("\n"," ");
            line = line.replaceAll("\r", " ");
            System.out.println(line);

            String startTag = "<" + args[0];
            String endTag = "</" + args[0] + ">";

            System.out.println(startTag + " " + endTag);

            ArrayList<String> result = new ArrayList<>();
            boolean tagExist = true;
            /*while (tagExist) {
                int start = line.indexOf(startTag);
                int end = line.lastIndexOf(endTag);
                if (start == -1)
                    tagExist = false;
                String findResult = line.substring(start,end+endTag.length());
                result.add(findResult);
                line = findResult;
                line = line.rep
            }*/
            Iterator<String> it = result.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
