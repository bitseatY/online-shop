package com.ecommerce.demo.Entites;

import jakarta.persistence.*;

import java.math.BigDecimal;
import  lombok.*;

@Entity
@Table(name="cart_items")
@Setter
@Getter
@NoArgsConstructor
public class CartItem {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long id;
      @ManyToOne(optional = false)
      @JoinColumn(name = "cart_id")
      private Cart cart;
      @OneToOne(optional = false)
      @JoinColumn(name="pro_id")
      private Product product;
      private  int  qty;
      private BigDecimal priceAtAdd;
      public CartItem(Cart cart,Product product,int qty,BigDecimal priceAtAdd){
          this.cart=cart;
          this.product=product;
          this.qty=qty;
          this.priceAtAdd=priceAtAdd;
      }


}
