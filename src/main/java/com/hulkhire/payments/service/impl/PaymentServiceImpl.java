package com.hulkhire.payments.service.impl;

import com.hulkhire.payments.constant.ValidatorEnum;
import com.hulkhire.payments.pojo.PaymentRequest;
import com.hulkhire.payments.pojo.PaymentResponse;
import com.hulkhire.payments.service.PaymentService;
import com.hulkhire.payments.service.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private ApplicationContext context;

    private Logger logger= LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Value("${validator.rules}")
    private String validationRules;


    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        logger.info("Received Payment Details: {}",paymentRequest);
        PaymentResponse paymentResponse=new PaymentResponse();
        paymentResponse.setId("1234");
        paymentResponse.setRedirectUrl("www.google.com"+paymentRequest.getId());
        logger.info("Payment Response"+paymentResponse);

        //Validation Check

        String[] rules=validationRules.split(",");

        for(String rule:rules){
            logger.info("VALIDATION CHECK : {}",rule);
             Class<? extends Validator>validatorClass=ValidatorEnum.getClassByName(rule);
            Validator validatorbean=context.getBean(validatorClass);
            logger.info("Validator Bean Retrieved: {} ",validatorbean.getClass().getSimpleName());
        }

        return paymentResponse;
    }
}
