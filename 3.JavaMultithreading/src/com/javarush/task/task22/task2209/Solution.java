package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
        String line;
        List<String> workArray = new ArrayList<>();
        while ((line = fr.readLine()) != null) {
            String[] lines = line.split(" ");
            for (int i = 0; i < lines.length; ++i) {
                workArray.add(lines[i]);
                //System.out.println(lines[i]);
            }
        }
        String[] arrayFromFile = workArray.toArray(new String[workArray.size()]);

        fr.close();
        br.close();
        StringBuilder result = getLine(arrayFromFile);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> arrList = new ArrayList<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        while (arrList.size() > 0) {
            for (int i = 0; i < arrList.size(); ++i) {
                if (result.size() == 0) {
                    result.add(arrList.get(i));
                    arrList.remove(i);
                    --i;
                    continue;
                }
                StringBuilder currentWord = new StringBuilder();
                StringBuilder wordInResult;
                if (arrList.size() > 0) {
                    currentWord.append(arrList.get(i));
                }
                for (int j = 0; j < result.size(); ++j) {
                    wordInResult = new StringBuilder();
                    wordInResult.append(result.get(j));

                    if (currentWord.substring(0, 1).equalsIgnoreCase(wordInResult.substring(wordInResult.length() - 1, wordInResult.length()))) {
                        if (result.size() < 2 || j + 1 == result.size()) {
                            result.add(j + 1, currentWord.toString());
                            arrList.remove(i);
                            --i;
                            ++j;
                            break;
                        } else {//next
                            wordInResult = new StringBuilder();
                            wordInResult.append(result.get(j + 1));
                            if (currentWord.substring(currentWord.length() - 1, currentWord.length()).equalsIgnoreCase(currentWord.substring(0, 1))) {
                                result.add(j + 1, currentWord.toString());
                                arrList.remove(i);
                                --i;
                                ++j;
                                break;
                            }
                        }
                    }
                    if (currentWord.substring(currentWord.length() - 1, currentWord.length()).equalsIgnoreCase(wordInResult.substring(0, 1))) {
                        if (result.size() < 2 || j - 1 <= 0) {
                            result.add(j, currentWord.toString());
                            arrList.remove(i);
                            --i;
                            ++j;
                            break;
                        } else if (j > 0){//previous
                            wordInResult = new StringBuilder();
                            wordInResult.append(result.get(j - 1));
                            if (currentWord.substring(0, 1).equalsIgnoreCase(wordInResult.substring(wordInResult.length() - 1, wordInResult.length()))) {
                                result.add(j + 1, currentWord.toString());
                                arrList.remove(i);
                                --i;
                                ++j;
                                break;
                            }
                        }
                    }
                }
            }
        }
        StringBuilder resultSb = new StringBuilder();
        for (String s : result) {
            resultSb.append(s);
            resultSb.append(" ");
        }

        if (words.length == 0) {
            return resultSb;
        }

        resultSb.replace(resultSb.lastIndexOf(" "), resultSb.lastIndexOf(" ") + 1, "");
        return resultSb;

    }
}
