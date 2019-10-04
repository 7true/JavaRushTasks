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
            br.close();
            fr.close();
            line = line.replaceAll("\n"," ");
            line = line.replaceAll("\r", " ");
            //System.out.println(line);

            String startTag = "<" + args[0];
            String endTag = "</" + args[0] + ">";

            //System.out.println(startTag + " " + endTag);

            ArrayList<String> result = new ArrayList<>();
            boolean tagExist = true;
            ArrayList<Integer> startTagsPos = new ArrayList<>();
            ArrayList<Integer> endTagsPos = new ArrayList<>();
            int start = 0, end = 0, endPrev = 0;
            ArrayList<Integer> nestedTags = new ArrayList<>();
            Integer nest = 0;
            ArrayList<Integer> nestPos = new ArrayList<>();
            while (true) {
                start = line.indexOf(startTag, start);
                if (start == -1) {
                    if (nest != 0) {
                        nestedTags.add(nest);
                        nestPos.add(endPrev);
                    }
                    break;
                }
                end = line.indexOf(endTag, end);
                if (endPrev > start) {
                    nest++;
                } else if (nest != 0) {
                    nestedTags.add(nest);
                    nestPos.add(endPrev);
                    nest = 0;
                }

                endPrev = end;
                startTagsPos.add(start++);
                endTagsPos.add(end++);
                //String findResult = line.substring(start,end+endTag.length());
            }

            ArrayList<Integer> endTagsFinal = new ArrayList<>();
            ArrayList<Integer> endFinal = new ArrayList<>();
            for (int i = 0; i < nestPos.size(); i++) {
                int currentIndex = endTagsPos.indexOf(nestPos.get(i));
                for (int j = currentIndex; j >= currentIndex - nestedTags.get(i); j--) {
                    endTagsFinal.add(endTagsPos.get(j));
                }
            }

            ArrayList<Integer> endIndexes = new ArrayList<>();
            int indexShift = 0;
            for (int i = 0; i < endTagsPos.size(); i++) {
                Integer ind = endTagsFinal.indexOf(endTagsPos.get(i));
                if (ind != -1) {
                    ind = ind + indexShift;
                    endIndexes.add(ind);
                } else {
                    endIndexes.add(i);
                    indexShift++;
                }
            }

            for (int i = 0; i < endIndexes.size(); i++) {
                endFinal.add(endTagsPos.get(endIndexes.get(i)));
            }
                 /*
                for (int k = 0; k < endTagsPos.size(); k++) {
                    if (endTagsPos.contains(endTagsFinal.get(i)) && (!endTagsFinal1.contains(endTagsFinal.get(i)))) {
                        endTagsFinal1.add(endTagsFinal.get(i));
                    }
                    else if(!endTagsFinal1.contains(endTagsPos.get(k))) {
                        endTagsFinal1.add(endTagsPos.get(k));
                    }
                }*/

 /*
 for (int i = 0; i < endTagsPos.size(); i++) {
 for (int k = 0; i < nestPos.size(); k++) {
 int currentIndex = endTagsPos.indexOf(nestPos.get(k));
 for (int j = currentIndex; j < nestedTags.get(i); j++) {
 endTagsFinal.add(endTagsPos.get(j));

 }
 }*/

/*
 for (int i = 0; i < startTagsPos.size() - 1; i++) {
 if (startTagsPos.get(i + 1) < endTagsPos.get(i)) {
 Integer tmp = startTagsPos.get(i);
 startTagsPos.set(i, startTagsPos.get(i+1));
 startTagsPos.set(i + 1,tmp);
 }
 //result.add(line.substring(startTagsPos.get(i), endTagsPos.get(i)));
 }*/

 /*
 Iterator<String> it = result.iterator();
 while (it.hasNext()) {
 System.out.println(it.next());
 }*/
/*
            Iterator<Integer> it = startTagsPos.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println("\n######");
            it = endTagsPos.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println("\n######");/*
            for (int i = 0; i < nestedTags.size(); i++) {
                System.out.println(nestedTags.get(i));
                System.out.println(nestPos.get(i));
            }
            System.out.println("\n######");
            it = endTagsFinal.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }

            System.out.println("\n######");
            it = endFinal.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println("\n######");*/
            for(int i = 0; i < startTagsPos.size(); i++) {
                System.out.println(line.substring(startTagsPos.get(i), endFinal.get(i) + +endTag.length()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}