package com.phgr.bff.payments.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendPaymentEvent(Long orderId, String status) {
        String message = orderId + ":" + status;
        kafkaTemplate.send("payment-events", message);
    }
}