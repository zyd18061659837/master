package com.itany.exceptionHandler;

import com.itany.exception.SmsCodeException;
import com.itany.exception.UserAlreadyLoginException;
import com.itany.exception.UserNotFoundException;
import com.itany.exception.UsernameAlreadyExistException;
import com.itany.vo.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author:wenlixu
 * Date:2019/4/11 22:00
 * Description:
 * Version:1.0
 */
@ControllerAdvice
public class UserExceptionHandler {


    @ResponseBody
    @ExceptionHandler(UserAlreadyLoginException.class)
    public AjaxResult handleUserAlreadyLoginException(Exception e){
        AjaxResult result = new AjaxResult();
        result.setMsg(e.getMessage());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(SmsCodeException.class)
    public AjaxResult handleSmsCodeException(Exception e){
        AjaxResult result = new AjaxResult();
        result.setMsg(e.getMessage());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public AjaxResult handleUserNotFoundException(Exception e){
        AjaxResult result = new AjaxResult();
        result.setMsg(e.getMessage());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(UsernameAlreadyExistException.class)
    public AjaxResult handleUsernameAlreadyExistException(Exception e){
        AjaxResult result = new AjaxResult();
        result.setMsg(e.getMessage());
        return result;
    }
}
