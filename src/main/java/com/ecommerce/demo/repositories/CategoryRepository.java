package com.ecommerce.demo.repositories;

import com.ecommerce.demo.entites.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findBySlug(String slug);
    Page<Category> findAll(Pageable pageable);
}
