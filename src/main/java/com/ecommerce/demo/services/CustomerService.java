package com.ecommerce.demo.services;

import com.ecommerce.demo.dtos.CategorySummary;
import com.ecommerce.demo.dtos.ProductSummary;
import com.ecommerce.demo.entites.*;
import com.ecommerce.demo.exceptions.*;
import com.ecommerce.demo.repositories.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    public CustomerService(ProductRepository productRepository, CartRepository cartRepository,
                           CartItemRepository cartItemRepository, UserRepository userRepository,
                           CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.cartRepository=cartRepository;
        this.cartItemRepository=cartItemRepository;
        this.userRepository=userRepository;
        this.categoryRepository=categoryRepository;
    }
    //public fetch for categories
    public Page<CategorySummary> fetchAllCategories(){
            Pageable pageable= PageRequest.of(0,10, Sort.by("name").ascending());
            Page<Category> categories=categoryRepository.findAll(pageable);
            return  categories.map(category -> new CategorySummary(category.getSlug(),category.getDescription()));
    }
    //public fetch for products
    public Page<ProductSummary> fetchAllProducts(String categorySlug){
        Category category=categoryRepository.findBySlug(categorySlug).orElseThrow(()->new ResourceNotFoundException("category not found"));
        Pageable pageable= PageRequest.of(0,10, Sort.by("name").ascending());
        Page<Product> products=productRepository.findByCategory(category,pageable);
        return  products.map(product -> new ProductSummary( product.getSlug(), product.getDescription()));
    }
    //public fetch for product variants



}
