package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Date orderDate;

    private String deliveryStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> payments;

    // Constructor por defecto
    public CustomerOrder() {}

    // Constructor con parámetros
    public CustomerOrder(Long id, Long customerId, Date orderDate, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    // Métodos adicionales
    public void addOrderItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeOrderItem(OrderItem item) {
        this.items.remove(item);
    }

    public BigDecimal calculateTotal() {
        return items.stream()
                .map(OrderItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void applyDiscount(Discount discount) {
        BigDecimal total = this.calculateTotal();
        BigDecimal discountedPrice = discount.applyDiscount(total);
        // Lógica adicional para ajustar el total del pedido si es necesario
    }

    public void sendForDelivery() {
        // Lógica para enviar el pedido a entrega
    }

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }
}
