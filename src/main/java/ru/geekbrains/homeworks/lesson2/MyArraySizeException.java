package ru.geekbrains.homeworks.lesson2;

public class MyArraySizeException extends RuntimeException{

    public MyArraySizeException() {
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
