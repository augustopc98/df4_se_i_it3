package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal productPrice;

    public OrderItem() {}

    public OrderItem(Long id, Long productId, int quantity, BigDecimal productPrice) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    public BigDecimal getPrice() { return productPrice.multiply(new BigDecimal(quantity)); }
    public boolean validateItem() { return quantity > 0 && productPrice.compareTo(BigDecimal.ZERO) > 0; }
}