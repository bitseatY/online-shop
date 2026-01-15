package com.ecommerce.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class MethodArgErrors {
    private String message;
    private Map<String,String> errors;

}
