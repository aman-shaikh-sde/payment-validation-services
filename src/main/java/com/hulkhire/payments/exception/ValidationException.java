package com.hulkhire.payments.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ValidationException extends RuntimeException{

    private final String errorMsg;
    private final String errorCode;
}
