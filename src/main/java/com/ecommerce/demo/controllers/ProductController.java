package com.ecommerce.demo.controllers;

import com.ecommerce.demo.dtos.ProductSummaryDto;
import com.ecommerce.demo.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{slug}/categories")
    public ResponseEntity<List<ProductSummaryDto>>  searchProductsByCategory(@PathVariable("slug") String slug, Pageable pageable){
        return ResponseEntity.ok(productService.searchProductsByCategory(slug,pageable));
    }
     //basic product search
    @GetMapping("/search")
    public Page<ProductSummaryDto> searchProducts(@RequestParam String q, @RequestParam(required = false) String category,
                                                                  @RequestParam(required = false) BigDecimal priceMin, @RequestParam(required = false) BigDecimal priceMax,
                                                                  Pageable pageable){
        return productService.search(q,category,priceMin,priceMax,pageable);
    }

}
