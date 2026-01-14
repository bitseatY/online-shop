package com.ecommerce.demo.entites;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import  lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="cart",orphanRemoval = true)
    List<CartItem> items;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;
    //ACTIVE, CHECKED-OUT, ABANDONED, EXPIRED
    private String status;
    public Cart(User user){
        this.user=user;
        status="loading";
    }



}
