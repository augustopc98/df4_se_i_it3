package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public void processPayment(@RequestParam Long orderId, @RequestBody Payment payment) {
        paymentService.processPayment(orderId, payment);
    }

    @GetMapping("/{paymentId}/status")
    public String checkPaymentStatus(@PathVariable Long paymentId) {
        return paymentService.checkPaymentStatus(paymentId);
    }
}