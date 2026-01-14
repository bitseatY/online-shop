package com.ecommerce.demo.exceptions;

public class InvalidArgumentException extends RuntimeException{
    private String message;
    public InvalidArgumentException(String message){
        super(message);
    }
}
