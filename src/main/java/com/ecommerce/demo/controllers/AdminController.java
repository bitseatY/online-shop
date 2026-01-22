package com.ecommerce.demo.controllers;

import com.ecommerce.demo.dtos.AddProductRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @PreAuthorize("hasRole")
    public void addProduct(@RequestBody AddProductRequest request){

    }
}
