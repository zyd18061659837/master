package com.itany.exception;

/**
 * Author:wenlixu
 * Date:2019/3/27 14:16
 * Description:
 * Version:1.0
 */
public class UserNotFoundException extends Exception {


    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
