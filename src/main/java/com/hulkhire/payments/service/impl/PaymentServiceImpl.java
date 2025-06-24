package com.hulkhire.payments.service.impl;

import com.hulkhire.payments.pojo.PaymentRequest;
import com.hulkhire.payments.pojo.PaymentResponse;
import com.hulkhire.payments.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    private Logger logger= LoggerFactory.getLogger(PaymentServiceImpl.class);
    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        logger.info("Received Payment Details: {}",paymentRequest);
        PaymentResponse paymentResponse=new PaymentResponse();
        paymentResponse.setId("1234");
        paymentResponse.setRedirectUrl("www.google.com"+paymentRequest.getId());

        logger.info("Payment Response"+paymentResponse);
        return paymentResponse;
    }
}
