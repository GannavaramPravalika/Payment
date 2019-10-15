package com.example.payment.service;

import com.example.payment.domain.Payment;

import java.util.Optional;

public interface IPaymentService {
    Payment save(Payment payment);

    Optional<Payment> getById(Long id);

    void deleteById(Long id);

    Optional<Payment> put(Long id, Payment payment);

    Payment getPaymentByPaymentId(String paymentId);
}
