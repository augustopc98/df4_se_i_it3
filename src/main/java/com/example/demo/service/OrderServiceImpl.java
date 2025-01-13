package com.example.demo.service;

import com.example.demo.model.CustomerOrder;
import com.example.demo.model.OrderItem;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public CustomerOrder placeOrder(Long customerId, List<OrderItem> items) {
        CustomerOrder order = new CustomerOrder();
        order.setCustomerId(customerId);
        order.setItems(items);
        return orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public void updateOrderStatus(Long orderId, String status) {
        CustomerOrder order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.updateDeliveryStatus(status);
            orderRepository.save(order);
        }
    }

    @Override
    public BigDecimal calculateOrderTotal(Long orderId) {
        CustomerOrder order = orderRepository.findById(orderId).orElse(null);
        return order != null ? order.calculateTotal() : BigDecimal.ZERO;
    }
}