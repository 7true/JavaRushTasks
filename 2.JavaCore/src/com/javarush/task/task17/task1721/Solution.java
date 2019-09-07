package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        try {
            String f1 = r.readLine();
            String f2 = r.readLine();
            br1 = new BufferedReader(new FileReader(f1));
            br2 = new BufferedReader(new FileReader(f2));
            String s1;

            while ((s1 = br1.readLine()) != null) {
                allLines.add(s1);
            }

            while ((s1 = br2.readLine()) != null) {
                forRemoveLines.add(s1);
            }

            Solution sol = new Solution();
            sol.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                br1.close();
                br2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public  void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
