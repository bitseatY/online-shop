package com.ecommerce.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPurchase {
    private long productId;
    private int quantity;
    public ProductPurchase(long productId,int quantity){
        this.productId=productId;
        this.quantity=quantity;
    }

}
