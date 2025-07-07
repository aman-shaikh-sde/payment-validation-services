package com.hulkhire.payments;

import com.google.gson.Gson;
import com.hulkhire.payments.pojo.PaymentRequest;
import com.hulkhire.payments.service.HMacSHA256Service;
import com.hulkhire.payments.service.impl.HMacSHA256ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class HmacServiceTest {
    private Gson gson=new Gson();

    private final HMacSHA256Service hMacSHA256Service=new HMacSHA256ServiceImpl(gson);

    @Test
    public void genrateSignatureTest() throws Exception{

        PaymentRequest request = new PaymentRequest();

        request.setId(1L);
        request.setPaymentMethod("UPI");
        request.setAmount(1500.50);
        request.setCurrency("INR");
        request.setTransactionId("TXN123456");
        request.setPaymentStatus("SUCCESS");
        request.setUserId(101L);


        String input=gson.toJson(request);
log.info("json Input: {}",input);

        String hashSignature=hMacSHA256Service.genrateHMACSignature(input);

        log.info("hashSignature: {}",hashSignature);

    }
}
