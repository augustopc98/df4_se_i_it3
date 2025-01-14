package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal productPrice;

    @Transient // No persistir este campo en la base de datos
    private BigDecimal price;

    // Constructor vacío
    public OrderItem() {}

    // Constructor con parámetros
    public OrderItem(Long productId, int quantity, BigDecimal productPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    // Calcula el precio basado en la cantidad y el precio del producto
    public BigDecimal getPrice() {
        if (productPrice == null || quantity <= 0) {
            return BigDecimal.ZERO; // Devuelve 0 en caso de valores inválidos
        }
        return productPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
