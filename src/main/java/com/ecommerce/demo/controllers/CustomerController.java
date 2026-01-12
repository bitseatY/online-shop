package com.ecommerce.demo.controllers;

import com.ecommerce.demo.dtos.AddItemRequest;
import com.ecommerce.demo.dtos.ApiResponse;
import com.ecommerce.demo.security.CustomUserDetailsService;
import com.ecommerce.demo.security.JwtUtil;
import com.ecommerce.demo.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    private  JwtUtil jwtUtil;
    public CustomerController(CustomerService customerService,JwtUtil jwtUtil){
        this.customerService=customerService;
        this.jwtUtil=jwtUtil;
    }


}
