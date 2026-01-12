package com.ecommerce.demo.entites;


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
    //quantity that is available for purchase at the moment
    private int stock;
    //quantity that is in the process of being sold ,if process fails it returns back to stock
    private  int reserved;
    //measurement unit like kilo, lb, ...
    private String quantityUnit;
    //available, sold-out , banned
    private String status;
    @ElementCollection
    @CollectionTable(name = "attributes",joinColumns=@JoinColumn(name="pro_id"))
    @MapKeyColumn(name="att_key")
    @Column(name="att_value")
    //characters of product like color,size , material, country imported .....
    private Map<String ,String> attributes;


    public Product(String name,String description,BigDecimal price,Category category,int stock,String quantityUnit,Map<String,String> attributes){
        this.name=name;
        this.description=description;
        this.price=price;
        this.category=category;
        this.stock =stock;
        this.reserved=0;
        this.attributes=attributes;
        this.quantityUnit=quantityUnit;
        status="available";
    }

}
