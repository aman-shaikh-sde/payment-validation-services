package com.hulkhire.payments.controller;

import com.hulkhire.payments.pojo.PaymentRequest;
import com.hulkhire.payments.pojo.PaymentResponse;
import com.hulkhire.payments.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payments")
public class PaymentController {
private Logger logger= LoggerFactory.getLogger(PaymentController.class);

@Autowired
private PaymentService service;


    @PostMapping
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest){

        logger.info("Recieved Payment Detais: {}",paymentRequest);
        PaymentResponse details=service.createPayment(paymentRequest);
        logger.info("Payment Creation Response: {}",details);

        return  details;
    }
}
