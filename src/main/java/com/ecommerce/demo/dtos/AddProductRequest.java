package com.ecommerce.demo.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class AddProductRequest {
    @NotBlank
    @Size(min = 5,max = 20,message = "product name can't be less than 5  or more than 20 letters")
    private String name;
    @NotBlank
    @Size(min = 15,max = 100,message = "product description can't be less than 15 or more than 100 letters ")
    private  String description;
    @NotNull
    @Min(value =1,message = "price can't be less than 1 ")
    private BigDecimal price;
    @NotBlank
    @Size(min = 5,message = "category slug can't be less than 5 letters")
    private  String categorySlug;
    @NotNull
    @Min(value = 1,message = "stock can't be less than 1 ")
    private int stock;
    @NotBlank
    private String quantityUnit;
    @NotNull
    @Size(min = 1,max = 30,message = "you must list minimum 1 to maximum 30 attributes for the product")
    private Map<String,String> attributes;
}
