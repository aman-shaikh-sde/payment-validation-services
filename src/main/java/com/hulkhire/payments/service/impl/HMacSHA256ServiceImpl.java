package com.hulkhire.payments.service.impl;

import com.google.gson.Gson;
import com.hulkhire.payments.exception.ValidationException;
import com.hulkhire.payments.pojo.PaymentRequest;
import com.hulkhire.payments.service.HMacSHA256Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class HMacSHA256ServiceImpl implements HMacSHA256Service {


    private final Gson gson;



    @Override
    public String genrateHMACSignature(String input) throws Exception {

        String secretKey = "This Is Our Secret Key";



        Mac HMac_SHA256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        HMac_SHA256.init(secretKeySpec);

        String hashSignature = Base64.getEncoder().encodeToString(HMac_SHA256.doFinal(input.getBytes()));

        log.info("hashSignature: {}", hashSignature);

        return hashSignature;
    }


    @Override
    public void verifyHmacSignature(String incomingHmacSignature, PaymentRequest paymentRequest) throws Exception {

        if (incomingHmacSignature == null || incomingHmacSignature.isEmpty()) {
            throw new ValidationException("HMAC Signature is Missing", "Error1004");
        }



        log.info("Verifying HMAC Signature: {}", incomingHmacSignature);

        String jsonReq=gson.toJson(paymentRequest);
        String genratedHmacSignature=genrateHMACSignature(jsonReq);

        if(!incomingHmacSignature.equals(genratedHmacSignature)){
            throw new ValidationException("Hmac Signature is Not Matched","Error1005");
        }

        log.info("Signature Verify successfully");

    }
}
