package com.itany.exceptionHandler;

import com.itany.exception.UserNotFoundException;
import com.itany.vo.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author:wenlixu
 * Date:2019/3/27 14:31
 * Description:
 * Version:1.0
 */
@ControllerAdvice
public class UserExceptionAdvisor {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public AjaxResult handleUserNotFoundException(Exception e){

        System.out.println("UserExceptionAdvisor.handleUserNotFoundException");
        AjaxResult result = new AjaxResult();

        result.setMsg(e.getMessage());

        return result;
    }

}
