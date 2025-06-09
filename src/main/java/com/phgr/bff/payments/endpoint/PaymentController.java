package com.phgr.bff.payments.endpoint;

import com.phgr.bff.payments.service.PaymentService;
import com.phgr.bff.payments.service.impl.PaymentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping("/confirm/{orderId}")
    @Operation(description = "Confimação de pagamento do pedido")
    public ResponseEntity<String> payOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(service.processPayment(orderId));
    }

    @PostMapping("/cancel/{orderId}")
    @Operation(description = "Cancelamento de pagamento do pedido")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
        service.cancelPayment(orderId);
        return ResponseEntity.ok(service.cancelPayment(orderId));
    }
}