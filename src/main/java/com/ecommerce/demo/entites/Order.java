package com.ecommerce.demo.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
@Setter
@Getter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name="user_id")
    private User user;
    private BigDecimal totalAmount;
    private String status;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> items;
    private LocalDate createdAt;

    public Order(User user,BigDecimal totalAmount,String status){
        createdAt=LocalDate.now();
        this.totalAmount=totalAmount;
        this.status=status;
        this.user=user;
    }

}
