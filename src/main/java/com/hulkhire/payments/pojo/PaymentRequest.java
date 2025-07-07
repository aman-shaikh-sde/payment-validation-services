package com.hulkhire.payments.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class PaymentRequest {

    private Long id;
    private String paymentMethod; // e.g., Credit Card, UPI, NetBanking
    private Double amount;
    private String currency; // e.g., INR, USD
    private String transactionId;
    private String paymentStatus; // e.g., SUCCESS, FAILED, PENDING
    private Long userId;

}
