package com.itany.exception;

/**
 * Author:wenlixu
 * Date:2019/4/11 15:40
 * Description:
 * Version:1.0
 */
public class SmsCodeException extends Exception {
    public SmsCodeException() {
    }

    public SmsCodeException(String message) {
        super(message);
    }

    public SmsCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SmsCodeException(Throwable cause) {
        super(cause);
    }

    public SmsCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
