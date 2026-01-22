package com.ecommerce.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CategorySummary {
    private String slug;
    private String description;
    private String parentSlug;
}
