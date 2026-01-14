package com.ecommerce.demo.repositories;

import com.ecommerce.demo.entites.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("select c from Cart c where c.user.id=:userId and c.status=:status")
    Cart findCart(@Param("userId") long userId, @Param("status") String status );

}
