package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private String fileName;
    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution s = new Solution("/home/ya/myFile");
        s.writeObject("yeah");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/home/ya/ser3"));
        out.writeObject(s);

        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("/home/ya/ser3"));
        Solution sNew = (Solution)objectInput.readObject();
        sNew.writeObject("добавим");
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
