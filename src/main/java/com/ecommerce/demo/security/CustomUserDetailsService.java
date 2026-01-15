package com.ecommerce.demo.security;

import com.ecommerce.demo.entites.User;
import com.ecommerce.demo.exceptions.ResourceNotFoundException;
import com.ecommerce.demo.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService  {
    private UserRepository repository;
    public CustomUserDetailsService(UserRepository repository){
        this.repository=repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=repository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user not found"));
        return new CustomUserDetails(user);
    }
}