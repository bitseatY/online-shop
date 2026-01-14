package com.ecommerce.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CartSummary {
    private long cartId;
    private int totalItems;
    private BigDecimal totalPrice;
    private List<CartItemsSummary> itemsSummary;
}
