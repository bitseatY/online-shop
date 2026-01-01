package com.ecommerce.demo.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="order_items")
@Getter
@Setter
@NoArgsConstructor

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name="order_id")
    private Order order;
    @OneToOne
    @JoinColumn(name="pro_id")
    private Product product;
    private int quantity;
    private BigDecimal priceAtAdd;
    public OrderItem(Order order, Product product, int quantity,BigDecimal priceAtAdd){
        this.order=order;
        this.product=product;
        this.quantity=quantity;
        this.priceAtAdd=priceAtAdd;
    }
}
