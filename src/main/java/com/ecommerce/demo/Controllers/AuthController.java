package com.ecommerce.demo.Controllers;

import com.ecommerce.demo.Entites.User;
import com.ecommerce.demo.Repositories.UserRepository;
import com.ecommerce.demo.Security.CustomUserDetailsService;
import com.ecommerce.demo.Security.JwtUtil;
import com.ecommerce.demo.Security.SecurityBeans;
import com.ecommerce.demo.dtos.RegistrationDto;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {
     private final UserRepository userRepository;
     private final SecurityBeans securityBeans;
     private final AuthenticationManager authManager;
     private final CustomUserDetailsService detailService;
     private final JwtUtil jwtUtil;
     public AuthController(UserRepository userRepository, SecurityBeans securityBeans, AuthenticationManager authManager, JwtUtil jwtUtil,
                           CustomUserDetailsService detailService){
         this.userRepository=userRepository;
         this.securityBeans=securityBeans;
         this.authManager=authManager;
         this.jwtUtil=jwtUtil;
         this.detailService=detailService;
     }

     @PostMapping("/register")
     public String registerUser(@Valid @RequestBody RegistrationDto request){
         User user=new User();
         user.setUsername(request.getUsername());
         user.setEmail(request.getEmail());
         user.setPassword(securityBeans.passwordEncoder().encode(request.getPassword()));
         if(request.getRoles()==null){
             user.setRoles(Set.of("User"));
         }
         else {
             user.setRoles(new HashSet<>(Arrays.asList(request.getRoles())));
         }
         userRepository.save(user);
         return "user successfully registered.";
     }
     @PostMapping("/login")
     public String login(@RequestBody LoginRequest loginRequest){
        authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        return jwtUtil.generateToken(detailService.loadUserByUsername(loginRequest.username()));
     }

    public record LoginRequest(String username,String password){}


}
