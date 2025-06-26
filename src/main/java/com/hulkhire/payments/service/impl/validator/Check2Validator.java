package com.hulkhire.payments.service.impl.validator;

import com.hulkhire.payments.pojo.PaymentRequest;
import com.hulkhire.payments.service.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class Check2Validator implements Validator {
    @Override
    public void validate(PaymentRequest paymentRequest) {

    }
}
