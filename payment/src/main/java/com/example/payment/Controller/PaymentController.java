package com.example.payment.Controller;

import com.example.payment.domain.Payment;
import com.example.payment.service.IPaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("payment/api/v1")
public class PaymentController {
    @Autowired
    IPaymentService iPaymentService;

    @Autowired
    ObjectMapper objectMapper;


    @PostMapping("/save")
    Payment save(@RequestBody Payment payment) {
        return iPaymentService.save(payment);
    }

    @GetMapping("/get/{id}")
    Optional<Payment> getById(@PathVariable("id") Long id) {
        return iPaymentService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        iPaymentService.deleteById(id);
    }

    @PutMapping("/put/{id}")
    Optional<Payment> put(@PathVariable Long id, @RequestBody Payment payment) {
        return iPaymentService.put(id, payment);
    }

    @GetMapping("/getById/{id}")
    Payment findPaymentByPaymentId(@PathVariable("id") String paymentId) {
        return iPaymentService.getPaymentByPaymentId(paymentId);
    }
}
