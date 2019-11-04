package com.javarush.task.task20.task2012;

import javax.naming.ldap.ExtendedRequest;
import java.io.*;

/* 
OutputToConsole
*/
public class Solution {
    public static String greeting = "Hello world";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputToConsole out = new OutputToConsole(3);
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("/home/ya/outSer"));
        out.writeExternal(objectOutput);
        objectOutput.close();
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("/home/ya/outSer"));
        out.readExternal(objectInput);
        objectInput.close();
        out.printMessage();
    }

    /**
     * OutputToConsole is an inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for displaying the [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        /**
         * Class constructor that sets the private counter field.
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * @param out A stream for externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A stream for de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

}
