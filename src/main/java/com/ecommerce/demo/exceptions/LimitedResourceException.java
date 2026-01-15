package com.ecommerce.demo.exceptions;

public class LimitedResourceException extends RuntimeException{
    private String message;
    public LimitedResourceException(String message){
        this.message=message;
    }
}
