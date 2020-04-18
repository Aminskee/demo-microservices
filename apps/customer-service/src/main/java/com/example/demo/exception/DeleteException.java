package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class DeleteException extends Exception {

    public DeleteException() {
        super("Member not found: Either the member is not active or not existant");
    }
}
