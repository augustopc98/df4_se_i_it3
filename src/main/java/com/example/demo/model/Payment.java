package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private BigDecimal amount;
    private Date paymentDate;
    private String paymentStatus;

    public Payment() {}

    public Payment(Long paymentId, BigDecimal amount, Date paymentDate, String paymentStatus) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    public void processPayment() {
        // Payment processing logic here
    }

    public String getPaymentStatus() { return paymentStatus; }
}