package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        ArrayList<Integer> bytesAr = new ArrayList<>();

        while (fis.available() > 0) {
            bytesAr.add(fis.read());
        }

        br.close();
        fis.close();
        HashMap<Integer, Integer> result = new HashMap<>();

        for (int b : bytesAr) {
            int frequencyCurrent = Collections.frequency(bytesAr, b);
            result.put(b, frequencyCurrent);
        }
        int maxFreq = Collections.max(result.values());
        Iterator mIterator = result.entrySet().iterator();

        while (mIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) mIterator.next();
            if (mapElement.getValue().equals(maxFreq)) {
                System.out.print(mapElement.getKey() + " ");
            }
        }

    }
}
