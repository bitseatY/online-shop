package Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name="order_items")
public class OrderItem {
    @ManyToOne(optional = false)
    @JoinColumn(name="order_id")
    private Order order;
    @JoinColumn(name="pro_id")
    private Product product;
    private int quantity;
    private BigDecimal priceAtAdd;
    public OrderItem(Order order, Product product, int quantity,BigDecimal priceAtAdd){
        this.order=order;
        this.product=product;
        this.quantity=quantity;
        this.priceAtAdd=priceAtAdd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPriceAtAdd(BigDecimal priceAtAdd) {
        this.priceAtAdd = priceAtAdd;
    }

    public BigDecimal getPriceAtAdd() {
        return priceAtAdd;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


}
