package com.phgr.bff.payments.domain;

import com.phgr.bff.payments.domain.enums.PaymentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentEvent {

    private Long orderId;
    private PaymentStatusEnum status;
}