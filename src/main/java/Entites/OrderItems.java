package Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class OrderItems {
    @ManyToOne(optional = false)
    @JoinColumn(name="order_id")
    private Order order;
    private  String product_name;
    private BigDecimal price;
    private int quantity;
    public OrderItems(Order order,String product_name,BigDecimal price,int quantity){
        this.order=order;
        this.product_name=product_name;
        this.price=price;
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
