package com.itany.user.api;

import com.itany.exception.SmsCodeException;
import com.itany.exception.UserAlreadyLoginException;
import com.itany.exception.UserNotFoundException;
import com.itany.exception.UsernameAlreadyExistException;
import com.itany.pojo.User;
import com.itany.vo.UserVO;

/**
 * Author:wenlixu
 * Date:2019/4/10 11:19
 * Description:
 * Version:1.0
 */
public interface UserService {

    User Login(User user) throws UserNotFoundException, UserAlreadyLoginException;

    void register(UserVO userVO) throws SmsCodeException, UsernameAlreadyExistException;

}
