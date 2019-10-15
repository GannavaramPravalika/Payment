package com.example.payment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountDisplayName;
    private String accountnumber;
    private Long amount;
    private String cardExpiryMonth;
    private String cardExpiryYear;
    private String cardTypeId;
    private String currencyCode;
    private Long currentAuthAmount;
    private Long currentSettledAmount;
    private String nameOnCard;
    @OneToOne(cascade = CascadeType.ALL)
    // @JsonIgnore
    private BillingAddress billingAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private PaymentTransaction paymentTransaction;

    @ManyToOne()
    @JsonIgnore
    private Payment payment;

}
