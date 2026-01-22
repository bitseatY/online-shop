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
    private String slug;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cat_id")
    private Category category;
    private BigDecimal price;
    //quantity of variant in the store
    private int stock;
    //measurement unit like kilo, lb, ...
    private String quantityUnit;
    //ACTIVE meaning it is ready to be sold and INACTIVE meaning  either variant is in someone's order or
    //variant is not available at the moment
    private String status;
    @ElementCollection
    @CollectionTable(name = "attributes",joinColumns=@JoinColumn(name="variant_id"))
    @MapKeyColumn(name="att_key")
    @Column(name="att_value")
    //characters of product like color,size , material, country imported .....
    private Map<String ,String> attributes;






    public Product(String name,String description,Category category){
        this.name=name;
        slug=name.toLowerCase().trim()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-");
        this.description=description;
        this.category=category;
    }

}
