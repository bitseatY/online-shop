package com.ecommerce.demo.controllers;

import com.ecommerce.demo.dtos.LoginRequest;
import com.ecommerce.demo.dtos.LoginResponse;
import com.ecommerce.demo.dtos.RegistrationResponse;
import com.ecommerce.demo.entites.Cart;
import com.ecommerce.demo.entites.User;
import com.ecommerce.demo.repositories.CartRepository;
import com.ecommerce.demo.repositories.UserRepository;
import com.ecommerce.demo.security.CustomUserDetailsService;
import com.ecommerce.demo.security.JwtUtil;
import com.ecommerce.demo.security.SecurityBeans;
import com.ecommerce.demo.dtos.UserRegistration;
import com.ecommerce.demo.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
     private  final AuthService authService;

     @PostMapping("/register")
     public ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody UserRegistration request){
         RegistrationResponse response= authService.register(request);
          return ResponseEntity.status(HttpStatus.CREATED).body(response);
     }

     @PostMapping("/login")
     public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        return    ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
     }

     @GetMapping("/health")
    public String health() {
        return "OK";
    }

}
