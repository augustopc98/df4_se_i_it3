package com.example.demo.service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void processPayment(Long orderId, Payment payment) {
        payment.processPayment();
        paymentRepository.save(payment);
    }

    @Override
    public String checkPaymentStatus(Long paymentId) {
        return paymentRepository.findById(paymentId).map(Payment::getPaymentStatus).orElse("Unknown");
    }
}