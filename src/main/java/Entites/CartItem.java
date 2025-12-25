package Entites;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="cart_items")
public class CartItem {
      @ManyToOne(optional = false)
      @JoinColumn(name = "cart_id")
      private Cart cart;
      @OneToOne
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

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPriceAtAdd() {
        return priceAtAdd;
    }

    public void setPriceAtAdd(BigDecimal priceAtAdd) {
        this.priceAtAdd = priceAtAdd;
    }


}
