package com.o4codes.todo.configs;

import com.o4codes.todo.exceptions.AlreadyExistException;
import com.o4codes.todo.exceptions.ErrorResponse;
import com.o4codes.todo.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleAlreadyExistException(AlreadyExistException ex) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()
        );

    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()
        );

    }
}
