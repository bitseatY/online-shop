package Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class CartItem {
      @ManyToOne(optional = false)
      @JoinColumn(name = "cart_id")
      private Cart cart;
      private String productName;
      private  int  qty;
      private BigDecimal priceAtAdd;
      public CartItem(Cart cart,String productName,int qty,BigDecimal priceAtAdd){
          this.cart=cart;
          this.productName=productName;
          this.qty=qty;
          this.priceAtAdd=priceAtAdd;
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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
