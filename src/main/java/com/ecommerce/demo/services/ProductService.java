package com.ecommerce.demo.services;

import com.ecommerce.demo.dtos.ProductPurchase;
import com.ecommerce.demo.dtos.ProductSummaryDto;
import com.ecommerce.demo.entites.Category;
import com.ecommerce.demo.entites.Product;
import com.ecommerce.demo.exceptions.CategoryNotFoundException;
import com.ecommerce.demo.repositories.CategoryRepository;
import com.ecommerce.demo.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    public List<ProductSummaryDto>  searchProductsByCategory(String slug, Pageable pageable){
        Category category=categoryRepository.findBySlug(slug).orElseThrow(CategoryNotFoundException::new);
        List<Product> products=productRepository.findByCategoryId(category.getId(),pageable);
        if(products.isEmpty()){
            throw new CategoryNotFoundException();
        }
        return   products.stream().map(product -> new ProductSummaryDto(product.getId(),product.getName(),
                                                          product.getSlug(),product.getPrice())).toList();
    }
    public Page<ProductSummaryDto> search(String q, String category, BigDecimal priceMin, BigDecimal priceMax, Pageable pageable){
        return productRepository.search(q, category, priceMin, priceMax, pageable);
    }
}
