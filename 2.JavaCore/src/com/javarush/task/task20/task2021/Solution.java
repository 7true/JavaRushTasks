package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static void main(String[] args) {

    }

    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream stream) throws IOException {
            throw new NotSerializableException("ahaha");
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            throw new NotSerializableException("ahaha");
        }

    }
}
