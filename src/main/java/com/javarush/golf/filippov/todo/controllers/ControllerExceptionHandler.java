package com.javarush.golf.filippov.todo.controllers;

import com.javarush.golf.filippov.todo.exception.EntityNotFoundException;
import com.javarush.golf.filippov.todo.exception.MyRequestException;
import com.javarush.golf.filippov.todo.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> requestMyException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    @ExceptionHandler(MyRequestException.class)
    public ResponseEntity<Task> putRequestException(MyRequestException e){
        return ResponseEntity.badRequest().body(e.getTask());
    }


}
