package com.hulkhire.payments.service.impl;

import com.hulkhire.payments.service.HMacSHA256Service;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Slf4j
public class HMacSHA256ServiceImpl implements HMacSHA256Service {
    @Override
    public String genrateHMACSignature(String input) throws Exception{

        String secretKey="This Is Our Secret Key";
        String msg="Java";


        Mac HMac_SHA256=Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec=new SecretKeySpec(secretKey.getBytes(),"HmacSHA256");
        HMac_SHA256.init(secretKeySpec);

        String hashSignature=Base64.getEncoder().encodeToString(HMac_SHA256.doFinal(msg.getBytes()));

        log.info("hashSignature: {}",hashSignature);

        return hashSignature;
    }
}
