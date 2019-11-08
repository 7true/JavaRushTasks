package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person out = new Person("Alx", "Mal", 31);
        out.setFather(new Person("Fath", "m", 56));
        out.setMother(new Person("Moth", "m", 55));
        List<Person> ch= new ArrayList<Person>();
        ch.add(new Person("Tanya", "m", 4));
        out.setChildren(ch);
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("/home/ya/ser1"));
        out.writeExternal(objectOutput);
        objectOutput.close();
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("/home/ya/ser1"));
        out.readExternal(objectInput);
        objectInput.close();
    }

    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Person() {

        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            children = (List<Person>)in.readObject();
        }
    }
}
