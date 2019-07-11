package com.itany.exception;

/**
 * Author:wenlixu
 * Date:2019/4/11 15:48
 * Description:
 * Version:1.0
 */
public class UsernameAlreadyExistException extends Exception {


    public UsernameAlreadyExistException() {
    }

    public UsernameAlreadyExistException(String message) {
        super(message);
    }

    public UsernameAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public UsernameAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
