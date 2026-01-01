package com.ecommerce.demo.Security;

import com.ecommerce.demo.Entites.User;
import com.ecommerce.demo.Repositories.UserRepository;
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
       User user=repository.findByUsername(username);
       return new org.springframework.security.core.userdetails.User(user.getUsername(),
               user.getPassword(),user.getRoles().stream()
                       .map(SimpleGrantedAuthority::new)
                                 .toList());
    }
}