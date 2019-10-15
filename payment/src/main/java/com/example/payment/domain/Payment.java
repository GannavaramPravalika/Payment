package com.example.payment.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amount;
//    @Enumerated(EnumType.STRING)
    private String paymentStatus;

    @Column(unique = true)
    private String paymentId;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<PaymentMethod> paymentMethod;

    @PrePersist
    public void prePersist() {
        paymentMethod.forEach(PaymentMethod -> PaymentMethod.setPayment(this));
    }
}