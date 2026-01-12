package com.ecommerce.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ApiError extends RuntimeException{
    private String message;
    private Map<String,String> errors;
    public ApiError(String message){
        super(message);
    }

}
