package com.ecommerce.demo.Repositories;

import com.ecommerce.demo.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
