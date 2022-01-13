package com.gudev.productercase.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFoundEception  extends RuntimeException{
    public PlayerNotFoundEception(String message){
        super(message);
    }
}
