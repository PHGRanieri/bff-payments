package com.phgr.bff.payments.service;

import com.phgr.bff.payments.config.PaymentProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    private PaymentProducer producer;

    public void processPayment(Long orderId) {
        producer.sendPaymentEvent(orderId, "PAID");
    }

    public void cancelPayment(Long orderId) {
        producer.sendPaymentEvent(orderId, "CANCELLED");
    }

}