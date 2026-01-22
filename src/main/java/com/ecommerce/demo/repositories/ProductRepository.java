package com.ecommerce.demo.repositories;

import com.ecommerce.demo.entites.Category;
import com.ecommerce.demo.entites.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByCategory(Category category,Pageable pageable);

}
