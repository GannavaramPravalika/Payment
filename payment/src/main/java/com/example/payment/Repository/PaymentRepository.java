package com.example.payment.Repository;

import com.example.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Payment findPaymentByPaymentId(String paymentId);
}
