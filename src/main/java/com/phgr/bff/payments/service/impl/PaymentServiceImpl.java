package com.phgr.bff.payments.service.impl;

import com.phgr.bff.payments.domain.PaymentEvent;
import com.phgr.bff.payments.domain.enums.PaymentStatusEnum;
import com.phgr.bff.payments.domain.exception.OrderNotFoundException;
import com.phgr.bff.payments.repository.OrderRepository;
import com.phgr.bff.payments.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Value("${topics.payment}")
    private String paymentTopic;

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplatePayment;
    private final OrderRepository repository;

    @Override
    public String processPayment(final Long orderId) {
        repository.findByIdAndStatus(orderId, PaymentStatusEnum.PENDING).orElseThrow(() -> new OrderNotFoundException(orderId));

        PaymentEvent event = PaymentEvent.builder()
                .status(PaymentStatusEnum.PAID)
                .orderId(orderId)
                .build();

        kafkaTemplatePayment.send(paymentTopic, event);

        return "Payment Processed for Order " + orderId;
    }

    @Override
    public String cancelPayment(final Long orderId) {

        repository.findByIdAndStatus(orderId, PaymentStatusEnum.PENDING).orElseThrow(() -> new OrderNotFoundException(orderId));

        PaymentEvent event = PaymentEvent.builder()
                .status(PaymentStatusEnum.CANCELLED)
                .orderId(orderId)
                .build();

        kafkaTemplatePayment.send(paymentTopic, event);
        return "Payment Cancelled for Order " + orderId;

    }


}