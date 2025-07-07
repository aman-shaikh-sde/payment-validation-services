package com.hulkhire.payments.service;

import com.hulkhire.payments.pojo.PaymentRequest;
import com.hulkhire.payments.pojo.PaymentResponse;

public interface HMacSHA256Service {

    public String genrateHMACSignature(String input)throws Exception;

    public void verifyHmacSignature(String incomingHmacSignature, PaymentRequest paymentRequest) throws Exception;
}
