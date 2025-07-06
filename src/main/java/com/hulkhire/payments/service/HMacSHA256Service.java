package com.hulkhire.payments.service;

public interface HMacSHA256Service {

    public String genrateHMACSignature(String input)throws Exception;
}
