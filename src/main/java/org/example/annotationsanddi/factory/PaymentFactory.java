package org.example.annotationsanddi.factory;

import org.example.annotationsanddi.contracts.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentFactory {
    Map<String, Payment> paymentTypes;
    public PaymentFactory(Map<String, Payment> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }
    public Payment getPaymentType(String type){
        return paymentTypes.getOrDefault(type.toLowerCase(), null);
    }
}
