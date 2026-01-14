package com.ecommerce.demo.services;

import com.ecommerce.demo.dtos.CartItemsSummary;
import com.ecommerce.demo.entites.Cart;
import com.ecommerce.demo.entites.CartItem;
import com.ecommerce.demo.entites.Product;
import com.ecommerce.demo.entites.User;
import com.ecommerce.demo.exceptions.*;
import com.ecommerce.demo.repositories.CartItemRepository;
import com.ecommerce.demo.repositories.CartRepository;
import com.ecommerce.demo.repositories.ProductRepository;
import com.ecommerce.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.math.BigDecimal;

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

    public CartItemsSummary addToCart(String slug, int quantity, long userId){
          if(quantity<1)
              throw new InvalidArgumentException("quantity can't be less than 1");
          User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException());
          Cart cart=cartRepository.findCart(userId,"ACTIVE");
          //if no active cart is present for user, create one
          if(cart==null){
              cart=new Cart(user);
              cart.setStatus("ACTIVE");
              cartRepository.save(cart);
          }
          Product product=productRepository.findBySlug(slug).orElseThrow(()->new ProductNotFoundException());
          if(product.getStock()<quantity){
              throw new InsufficientStockException();
          }
          //if item is already present just increase quantity, do not save it as a new item
          CartItem cartItem=new CartItem(cart,product,quantity);
          boolean isItemPresent=false;
          for(CartItem item:cart.getItems()){
              if(item.getProduct().equals(cartItem.getProduct())){
                  item.setQuantity(item.getQuantity()+cartItem.getQuantity());
                  isItemPresent=true;
              }
          }
          if(!isItemPresent){
              cartItemRepository.save(cartItem);
              cart.getItems().add(cartItem);
          }
         return  new CartItemsSummary(cartItem.getId(),cartItem.getProduct().getName(),cartItem.getQuantity(),
                                  cartItem.getPriceAtAdd(),cartItem.getPriceAtAdd().multiply(BigDecimal.valueOf(cartItem.getQuantity())));


    }

}
