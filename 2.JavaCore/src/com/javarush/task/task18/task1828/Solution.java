package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        if ((args.length == 5 || args.length == 2) && (args[0].equals("-u") || args[0].equals("-d"))) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String fileName = br.readLine();
                BufferedReader brf = new BufferedReader(new FileReader(fileName));

                ArrayList<String> arrString = new ArrayList<>();

                String line;
                while ((line = brf.readLine()) != null) {
                    arrString.add(line);
                }

                int idUpdate = Integer.parseInt(args[1]);
                int currentId;
                StringBuilder sb = new StringBuilder();
                if (args.length == 5) {
                    sb.append(args[1]);
                    sb = sbAppendSpaces(sb, 8);
                    sb.append(args[2]);
                    sb = sbAppendSpaces(sb, 38);
                    sb.append(args[3]);
                    sb = sbAppendSpaces(sb, 46);
                    sb.append(args[4]);
                    sb = sbAppendSpaces(sb, 50);
                }
                String stringReplacement = sb.toString();
                brf.close();
                BufferedWriter fbw = new BufferedWriter(new FileWriter(fileName));
                //update
                if (args[0].equals("-u")) {
                    for (int i = 0; i < arrString.size(); i++) {
                        if (Integer.parseInt(arrString.get(i).substring(0, 8).trim()) == idUpdate) {
                            fbw.write(stringReplacement);
                            fbw.write("\n");
                            continue;
                        }
                        fbw.write(arrString.get(i));
                        if (i == arrString.size() - 1) break;
                        fbw.write("\n");
                    }
                }

                //delete
                if (args[0].equals("-d")) {
                    for (int i = 0; i < arrString.size(); i++) {
                        if (Integer.parseInt(arrString.get(i).substring(0, 8).trim()) == idUpdate) {
                            continue;
                        }
                        fbw.write(arrString.get(i));
                        if (i == arrString.size() - 1) break;
                        fbw.write("\n");
                    }
                }

                fbw.close();
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static StringBuilder sbAppendSpaces(StringBuilder sb, int size) {
        while (sb.length() < size)
            sb.append(" ");
        return sb;
    }
}
