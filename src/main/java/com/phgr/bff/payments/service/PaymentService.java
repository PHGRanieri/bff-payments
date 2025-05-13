package com.phgr.bff.payments.service;

import com.phgr.bff.payments.domain.PaymentEvent;
import com.phgr.bff.payments.domain.enums.PaymentStatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${topics.payment}")
    private String paymentTopic;

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplatePayment;

    public void processPayment(Long orderId) {
        PaymentEvent event = PaymentEvent.builder()
                .status(PaymentStatusEnum.PAID)
                .orderId(orderId)
                .build();
        kafkaTemplatePayment.send(paymentTopic, event);
    }

    public void cancelPayment(Long orderId) {
        PaymentEvent event = PaymentEvent.builder()
                .status(PaymentStatusEnum.CANCELLED)
                .orderId(orderId)
                .build();
        kafkaTemplatePayment.send(paymentTopic, event);
    }
}