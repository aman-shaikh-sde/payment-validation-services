package com.hulkhire.payments.controller;

import com.hulkhire.payments.exception.ValidationException;
import com.hulkhire.payments.pojo.PaymentRequest;
import com.hulkhire.payments.pojo.PaymentResponse;
import com.hulkhire.payments.service.HMacSHA256Service;
import com.hulkhire.payments.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.hulkhire.payments.constant.constant.PAYMENT_REQ;

@Slf4j
@RestController
@RequestMapping(PAYMENT_REQ)
public class PaymentController {
    private Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService service;

    @Autowired
    private HMacSHA256Service hMacSHA256Service;

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment
            (@RequestBody PaymentRequest paymentRequest,
             @RequestHeader(value = "sign-header",required = false)
                                                         String hmacSignature) throws Exception {

        logger.info("recieved hmacSignature: {}",hmacSignature);
        hMacSHA256Service.verifyHmacSignature(hmacSignature,paymentRequest);

        logger.info("Recieved Payment Detais: {}", paymentRequest);
        PaymentResponse details = service.createPayment(paymentRequest);
        logger.info("Payment Creation Response: {}", details);


        return new ResponseEntity<>(details, HttpStatus.CREATED);
    }
}
