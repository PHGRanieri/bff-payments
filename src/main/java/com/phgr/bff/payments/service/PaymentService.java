package com.phgr.bff.payments.service;

public interface PaymentService {

    String processPayment (final Long orderId);

    String cancelPayment (final Long orderId);

}
