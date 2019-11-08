package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    private transient final String pattern = "dd MMMM yyyy, EEEE";
    String string;
    private transient Date currentDate;
    private transient int temperature;
    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution savedObject = new Solution(3);
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("/home/ya/ser2"));
        objectOutput.writeObject(savedObject);
        objectOutput.close();

        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("/home/ya/ser2"));
        Solution loadedObject = (Solution) objectInput.readObject();
        if (savedObject.toString().equals(loadedObject.string))
            System.out.println("true");
    }

    @Override
    public String toString() {
        return this.string;
    }
}
