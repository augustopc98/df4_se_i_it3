package com.example.demo.service;

import com.example.demo.model.CustomerOrder;
import com.example.demo.model.OrderItem;
import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    CustomerOrder placeOrder(Long customerId, List<OrderItem> items);
    void cancelOrder(Long orderId);
    void updateOrderStatus(Long orderId, String status);
    BigDecimal calculateOrderTotal(Long orderId);
}