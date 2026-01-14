package com.ecommerce.demo.security;

import com.ecommerce.demo.entites.User;
import com.ecommerce.demo.exceptions.UserNotFoundException;
import com.ecommerce.demo.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=repository.findByUsername(username).orElseThrow(UserNotFoundException::new);
       return new CustomUserDetails(user.getId(),
               user.getEmail(),user.getPassword(),user.getRoles().stream()
                       .map(SimpleGrantedAuthority::new)
                                 .toList());
    }
}