package org.example.annotationsanddi.service;

import org.example.annotationsanddi.contracts.Payment;
import org.example.annotationsanddi.factory.PaymentFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentFactory paymentFactory;

    public PaymentService(
            PaymentFactory paymentFactory
    ) {
        this.paymentFactory = paymentFactory;
    }

    public ResponseEntity<?> pay(double amount, String type){
        Payment paymentType = paymentFactory.getPaymentType(type);
        if(paymentType == null){
            return ResponseEntity.badRequest().body("Invalid Payment Type");
        }
        boolean paymentStatus = paymentType.pay(amount);
        if(paymentStatus){
            return ResponseEntity.ok("Payment Successful");
        }
        return ResponseEntity.badRequest().body("Payment Failed");
    }
}
