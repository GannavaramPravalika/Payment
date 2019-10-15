package com.example.payment.service;

import com.example.payment.domain.Payment;
import com.example.payment.Repository.PaymentRepository;
import com.example.payment.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class PaymentService implements IPaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        long total=0;
        List<PaymentMethod> paymentMethod=payment.getPaymentMethod();

        for(int i=0;i<paymentMethod.size();i++)
        {
            PaymentMethod paymentMethod1=paymentMethod.get(i);
            total=total+paymentMethod1.getAmount();
        }
        System.out.println(total);
        payment.setAmount(total);
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> getById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Optional<Payment> put(Long id, Payment payment) {
        Optional<Payment> payment1 = paymentRepository.findById(id);
//       // System.out.println("asdf"+ payment1);
//        if(payment1.isPresent())
//        {
//            paymentRepository.save(payment);
//        }
        if (paymentRepository.findById(id).isPresent()) {
            paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public Payment getPaymentByPaymentId(String paymentId) {
        return paymentRepository.findPaymentByPaymentId(paymentId);
    }

}
