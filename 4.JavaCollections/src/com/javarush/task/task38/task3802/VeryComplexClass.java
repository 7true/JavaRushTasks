package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

public class VeryComplexClass {
    public static void main(String[] args) throws Exception {
        VeryComplexClass vcc = new VeryComplexClass();
        vcc.veryComplexMethod();
    }

    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        this.clone();
    }
}
