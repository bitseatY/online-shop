package com.ecommerce.demo.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception){
       return ResponseEntity.status(HttpStatus.CONFLICT)
               .body(new ApiError("email already exists"));


    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> errors=new HashMap<>();
        exception.getBindingResult().getFieldErrors().
                forEach(error->errors.put(error.getField(),error.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError("validation failed",errors));
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public  ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException exception){
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiError("simultaneous registration happening with identical email"));
    }
    @ExceptionHandler(UserNotFoundException.class)
    public  ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("user not found"));
    }



}
