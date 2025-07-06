package com.hulkhire.payments;

import com.hulkhire.payments.service.HMacSHA256Service;
import com.hulkhire.payments.service.impl.HMacSHA256ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class HmacServiceTest {

    private final HMacSHA256Service hMacSHA256Service=new HMacSHA256ServiceImpl();

    @Test
    public void genrateSignatureTest() throws Exception{

        String input="{\"name\":\"Aman Shaikh\"}";

        String hashSignature=hMacSHA256Service.genrateHMACSignature(input);

        log.info("hashSignature: {}",hashSignature);

    }
}
