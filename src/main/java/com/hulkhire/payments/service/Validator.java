package com.hulkhire.payments.service;

import com.hulkhire.payments.pojo.PaymentRequest;

public interface Validator {

    public void validate(PaymentRequest paymentRequest);
}
