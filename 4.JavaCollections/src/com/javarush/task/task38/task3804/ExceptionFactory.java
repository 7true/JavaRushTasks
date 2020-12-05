package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable createException(Enum exceptionEnum) {
        if (exceptionEnum == null) {
            return new IllegalArgumentException();
        }

        String message = exceptionEnum.name().toLowerCase().replaceAll("[_]", " ");
        message = message.substring(0, 1).toUpperCase() + message.substring(1);

        switch (exceptionEnum.getClass().getSimpleName()) {
            case "ApplicationExceptionMessage":
                return new Exception(message);
            case "DatabaseExceptionMessage":
                return new RuntimeException(message);
            case "UserExceptionMessage":
                return new Error(message);
            default:
                return new IllegalArgumentException();
        }
    }
}
