package com.cloud.bluewhale.exception;

/**
 * 自定义异常
 */
public class CustomException extends RuntimeException {

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
