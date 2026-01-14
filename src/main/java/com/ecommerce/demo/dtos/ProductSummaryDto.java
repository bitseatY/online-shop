package com.ecommerce.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
public class ProductSummaryDto {
     private long id;
     private String name;
     private String slug;
     private BigDecimal price;

}
