package com.ecommerce.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class UserResponse {
    private long id;
    private String email;
    private String name;
    private Set<String> roles;
}
