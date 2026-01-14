package com.ecommerce.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
public class CartItemsSummary {
    private long id;
    private String name;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
}
