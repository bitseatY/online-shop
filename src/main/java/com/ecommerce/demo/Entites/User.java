package com.ecommerce.demo.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles",joinColumns = @JoinColumn(name="user_id"))
    @Column(name="role")
    private Set<String> roles=new HashSet<>();
    private User(String username, String password, String email, Set<String> roles){
        this.email=email;
        this.roles=roles;
        this.password=password;
        this.username = username;
    }


}
