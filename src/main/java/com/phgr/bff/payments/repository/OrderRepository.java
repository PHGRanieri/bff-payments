package com.phgr.bff.payments.repository;

import com.phgr.bff.payments.domain.entity.Order;
import com.phgr.bff.payments.domain.enums.PaymentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByIdAndStatus(Long id, PaymentStatusEnum status);

}