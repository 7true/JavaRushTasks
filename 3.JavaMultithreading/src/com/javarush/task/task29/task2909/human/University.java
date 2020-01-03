package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Student getStudentWithAverageGrade(double averageGrade) {
    Stream <Student> sStream = students.stream();
    return sStream
            .filter(st -> st.getAverageGrade() == averageGrade)
            .findAny().get();
    }

    public Student getStudentWithMaxAverageGrade() {
        Stream <Student> sStream = students.stream();
        return sStream.max(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }

    public Student getStudentWithMinAverageGrade() {
        Stream <Student> sStream = students.stream();
        return sStream.min(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }
    public void expel(Student student) {
        students.remove(student);
    }
}