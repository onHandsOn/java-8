package com.carbonit.java8.exception;

public class NoStudentFoundException extends Exception{

    public NoStudentFoundException() {
    }

    public NoStudentFoundException(String message) {
        super(message);
    }
}
