package com.ecommerce.demo.services;
import com.ecommerce.demo.dtos.AddProductRequest;
import com.ecommerce.demo.entites.Category;
import com.ecommerce.demo.entites.Product;
import com.ecommerce.demo.exceptions.ResourceNotFoundException;
import com.ecommerce.demo.repositories.CategoryRepository;
import com.ecommerce.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public AdminService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

}
