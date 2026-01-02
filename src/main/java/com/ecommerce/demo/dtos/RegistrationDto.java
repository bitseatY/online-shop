package com.ecommerce.demo.dtos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class RegistrationDto {
    @NotBlank
    @Size(min = 8)
    private String username;
    @NotBlank
    @Email
    private String email;
    @Size(min = 10)
    private String password;
    private String[] roles;

    public RegistrationDto(String username, String email, String password, String[] roles) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;

    }
}

