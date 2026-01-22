package com.ecommerce.demo.controllers;

import com.ecommerce.demo.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }



}
