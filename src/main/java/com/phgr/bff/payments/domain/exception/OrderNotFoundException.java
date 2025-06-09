package com.phgr.bff.payments.domain.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super("Order " + orderId + " not found or payment already processed.");
    }
}