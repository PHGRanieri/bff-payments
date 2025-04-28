package com.phgr.bff.payments.endpoint;

import com.phgr.bff.payments.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/confirm/{orderId}")
    @Operation(description = "Confimação de pagamento do pedido")
    public ResponseEntity<String> payOrder(@PathVariable Long orderId) {
        service.processPayment(orderId);
        return ResponseEntity.ok("Payment Processed for Order " + orderId);
    }

    @PostMapping("/cancel/{orderId}")
    @Operation(description = "Cancelamento de pagamento do pedido")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
        service.cancelPayment(orderId);
        return ResponseEntity.ok("Payment Cancelled for Order " + orderId);
    }
}