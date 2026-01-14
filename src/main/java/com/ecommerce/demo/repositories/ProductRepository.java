package com.ecommerce.demo.repositories;

import com.ecommerce.demo.dtos.ProductSummaryDto;

import com.ecommerce.demo.entites.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(long id);
    Optional<Product> findBySlug(String slug);

    List<Product> findByCategoryId(long id, Pageable pageable);

    @Query("select new com.ecommerce.demo.dtos.ProductSummaryDto(p.id,p.name,p.slug,p.price)" +
            " from Product p where LOWER(p.name) LIKE CONCAT('%', :q, '%')\n" +
            "AND (:category IS NULL OR p.category.slug = :category)\n" +
            "AND (:priceMin IS NULL OR p.price >= :priceMin)\n" +
            "AND (:priceMax IS NULL OR p.price <= :priceMax)")
    Page<ProductSummaryDto> search(String q, String category, BigDecimal priceMin, BigDecimal priceMax, Pageable pageable);

}
