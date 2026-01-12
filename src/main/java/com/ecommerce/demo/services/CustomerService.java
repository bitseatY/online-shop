package com.ecommerce.demo.services;

import com.ecommerce.demo.entites.Cart;
import com.ecommerce.demo.entites.CartItem;
import com.ecommerce.demo.entites.Product;
import com.ecommerce.demo.exceptions.ApiError;
import com.ecommerce.demo.repositories.CartItemRepository;
import com.ecommerce.demo.repositories.CartRepository;
import com.ecommerce.demo.repositories.ProductRepository;
import com.ecommerce.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private UserRepository userRepository;
    public CustomerService(ProductRepository productRepository, CartRepository cartRepository,
                           CartItemRepository cartItemRepository, UserRepository userRepository){
        this.productRepository=productRepository;
        this.cartRepository=cartRepository;
        this.cartItemRepository=cartItemRepository;
        this.userRepository=userRepository;
    }
}
