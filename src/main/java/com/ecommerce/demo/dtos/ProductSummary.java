package com.ecommerce.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductSummary {
     private String slug;
     private String description;
     private BigDecimal price;


}
