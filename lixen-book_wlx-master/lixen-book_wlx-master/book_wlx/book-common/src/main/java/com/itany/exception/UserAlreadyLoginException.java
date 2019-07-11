package com.itany.exception;

/**
 * Author:wenlixu
 * Date:2019/4/11 11:11
 * Description:
 * Version:1.0
 */
public class UserAlreadyLoginException extends Exception {

    public UserAlreadyLoginException() {
    }

    public UserAlreadyLoginException(String message) {
        super(message);
    }

    public UserAlreadyLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyLoginException(Throwable cause) {
        super(cause);
    }

    public UserAlreadyLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
