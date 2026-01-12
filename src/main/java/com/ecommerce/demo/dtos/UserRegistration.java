package com.ecommerce.demo.dtos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
public class UserRegistration {
    @NotBlank
    @Size(min = 5,message = "username can't be less than 5 characters")
    private String username;
    @NotBlank
    @Email(message = "invalid email")
    private String email;
    @Size(min = 6,message = "password can't be less than 6 characters.")
    private String password;

}

