package com.javarush.task.testCode;

import java.lang.reflect.Field;

class B {
    public static void main(String[] args) throws Exception {
        String value = "Old value";
        System.out.println(value);

        //Получаем поле value в классе String
        Field field = value.getClass().getDeclaredField("value");
        //Разрешаем изменять его
        field.setAccessible(true);
        //Устанавливаем новое значение
        field.set(value, "JavaRush".toCharArray());

        System.out.println(value);

    }
}