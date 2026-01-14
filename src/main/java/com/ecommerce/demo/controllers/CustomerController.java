package com.ecommerce.demo.controllers;

import com.ecommerce.demo.dtos.AddItemRequest;
import com.ecommerce.demo.dtos.ApiResponse;
import com.ecommerce.demo.dtos.CartItemsSummary;
import com.ecommerce.demo.security.CustomUserDetails;
import com.ecommerce.demo.security.CustomUserDetailsService;
import com.ecommerce.demo.security.JwtUtil;
import com.ecommerce.demo.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    private CustomerService customerService;
    private  JwtUtil jwtUtil;
    private CustomUserDetailsService detailsService;
    public CustomerController(CustomerService customerService,JwtUtil jwtUtil,CustomUserDetailsService detailsService){
        this.customerService=customerService;
        this.jwtUtil=jwtUtil;
        this.detailsService=detailsService;
    }

    @PostMapping("/addtocart/{slug}/{quantity}")
    public ResponseEntity<CartItemsSummary> addToCart(@PathVariable("slug") String slug, int quantity, @AuthenticationPrincipal CustomUserDetails user){
        return  ResponseEntity.ok(customerService.addToCart(slug,quantity,user.getId()));
    }


}
