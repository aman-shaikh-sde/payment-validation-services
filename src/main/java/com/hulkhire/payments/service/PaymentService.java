package com.hulkhire.payments.service;

import com.hulkhire.payments.pojo.PaymentRequest;
import com.hulkhire.payments.pojo.PaymentResponse;

public interface PaymentService {

    public PaymentResponse createPayment(PaymentRequest paymentRequest);

}
