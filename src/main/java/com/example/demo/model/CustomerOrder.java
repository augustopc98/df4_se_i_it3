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

    public CustomerOrder() {}

    public CustomerOrder(Long id, Long customerId, Date orderDate, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.items = items;
    }

    public void addOrderItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeOrderItem(OrderItem item) {
        this.items.remove(item);
    }

    public BigDecimal calculateTotal() {
        return items.stream().map(OrderItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void applyDiscount(Discount discount) {
        BigDecimal total = this.calculateTotal();
        BigDecimal discountedPrice = discount.applyDiscount(total);
        // Adjust the order total logic
    }

    public void sendForDelivery() {
        // Logic to send for delivery
    }

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }

    public Date getOrderDate() { return orderDate; }
    public Long getCustomerId() { return customerId; }
}