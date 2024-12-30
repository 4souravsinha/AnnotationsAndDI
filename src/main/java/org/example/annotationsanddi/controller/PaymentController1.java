package org.example.annotationsanddi.controller;

import org.example.annotationsanddi.DTO.PaymentDetails;
import org.example.annotationsanddi.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController1 {
    PaymentService paymentService;
    public PaymentController1(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping
    public ResponseEntity<?> pay(@RequestBody PaymentDetails p) {
        return paymentService.pay(p.amount(), p.type());
    }
}
