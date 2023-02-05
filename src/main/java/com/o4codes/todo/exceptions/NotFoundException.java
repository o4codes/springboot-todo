package com.o4codes.todo.exceptions;

public class NotFoundException extends RuntimeException{
    private String message;
    public NotFoundException(){};
    public NotFoundException(String msg){
        super(msg);
        this.message = msg;
    }
}
