package Entites;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Map;

@Entity
@Table(name="products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cat_id")
    private Category category;
    private int quantity;
    private String status;
    private String qtyUnit;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}
