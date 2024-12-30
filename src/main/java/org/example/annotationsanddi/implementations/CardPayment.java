package org.example.annotationsanddi.implementations;

import org.example.annotationsanddi.contracts.Payment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("card")
public class CardPayment implements Payment {

    @Override
    public boolean pay(double amount) {
        System.out.println("amount " + amount + "paid using Card");
        return true;
    }
}
