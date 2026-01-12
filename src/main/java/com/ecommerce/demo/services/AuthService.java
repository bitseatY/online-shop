package com.ecommerce.demo.services;

import com.ecommerce.demo.dtos.*;
import com.ecommerce.demo.entites.Cart;
import com.ecommerce.demo.entites.User;
import com.ecommerce.demo.exceptions.EmailAlreadyExistsException;
import com.ecommerce.demo.exceptions.UserNotFoundException;
import com.ecommerce.demo.repositories.CartRepository;
import com.ecommerce.demo.repositories.UserRepository;
import com.ecommerce.demo.security.JwtUtil;
import com.ecommerce.demo.security.SecurityBeans;
import lombok.AllArgsConstructor;
import org.hibernate.service.UnknownServiceException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthService {
    private  final  SecurityBeans securityBeans;
    private  final UserRepository userRepository;
    private  final CartRepository cartRepository;
    private  final AuthenticationManager authManager;
    private  final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;


    public RegistrationResponse register(UserRegistration request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException();
        }
        User user=new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(securityBeans.passwordEncoder().encode(request.getPassword()));
        user.setRoles(Set.of("CUSTOMER"));
        userRepository.save(user);
        return  new RegistrationResponse("Account created successfully.",
                                            new UserResponse(user.getId(), user.getEmail(), user.getUsername(), user.getRoles()),
                                            "LOGIN");



    }
    public LoginResponse login(LoginRequest request){
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token=jwtUtil.generateToken(userDetailsService.loadUserByUsername(request.getUsername()));
        User user=userRepository.findByUsername(request.getUsername()).orElseThrow(UserNotFoundException::new);
        return  new LoginResponse(token,"Bearer",60*60*1000,
                        new UserResponse(user.getId(), user.getEmail(),user.getUsername(),user.getRoles()));

    }




}
