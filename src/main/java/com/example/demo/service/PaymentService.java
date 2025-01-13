package com.example.demo.service;

import com.example.demo.model.Payment;

public interface PaymentService {
    void processPayment(Long orderId, Payment payment);
    String checkPaymentStatus(Long paymentId);
}