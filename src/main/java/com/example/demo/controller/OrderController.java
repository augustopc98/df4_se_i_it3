package com.example.demo.controller;

import com.example.demo.model.CustomerOrder;
import com.example.demo.model.OrderItem;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public CustomerOrder placeOrder(@RequestParam Long customerId, @RequestBody List<OrderItem> items) {
        return orderService.placeOrder(customerId, items);
    }

    @PutMapping("/cancel/{orderId}")
    public void cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
    }

    @PutMapping("/update-status/{orderId}")
    public void updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        orderService.updateOrderStatus(orderId, status);
    }

    @GetMapping("/{orderId}/total")
    public BigDecimal calculateOrderTotal(@PathVariable Long orderId) {
        return orderService.calculateOrderTotal(orderId);
    }
}