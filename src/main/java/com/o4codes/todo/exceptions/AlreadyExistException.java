package com.o4codes.todo.exceptions;

public class AlreadyExistException extends RuntimeException{
    private String message;

    public AlreadyExistException(){}

    public AlreadyExistException(String message) {
        this.message = message;
    }

}
