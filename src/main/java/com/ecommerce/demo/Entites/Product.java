package com.ecommerce.demo.Entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Entity
@Table(name="products")
@NoArgsConstructor
@Setter
@Getter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cat_id")
    private Category category;
    private int quantity;
    private String status;
    @ElementCollection
    @CollectionTable(name = "attributes",joinColumns=@JoinColumn(name="pro_id"))
    @MapKeyColumn(name="att_key")
    @Column(name="att_value")
    private Map<String ,String> attributes;


    public Product(String name,String description,BigDecimal price,Category category,int quantity,Map<String,String> attributes){
        this.name=name;
        this.description=description;
        this.price=price;
        this.category=category;
        this.quantity=quantity;
        this.attributes=attributes;
        status="active";
    }

}
