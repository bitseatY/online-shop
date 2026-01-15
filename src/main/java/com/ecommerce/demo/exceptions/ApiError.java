package com.ecommerce.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter

public class ApiError {
    private String message;
    public ApiError(String message){

        this.message=message;

    }

    @Override
    public String toString() {
        return "message:"+message;
    }
}
