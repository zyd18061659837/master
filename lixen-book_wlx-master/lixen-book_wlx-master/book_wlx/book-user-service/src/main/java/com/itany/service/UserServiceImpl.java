package com.itany.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itany.constant.Constants;
import com.itany.exception.SmsCodeException;
import com.itany.exception.UserAlreadyLoginException;
import com.itany.exception.UserNotFoundException;
import com.itany.exception.UsernameAlreadyExistException;
import com.itany.mapper.UserMapper;
import com.itany.pojo.User;
import com.itany.user.api.UserService;
import com.itany.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Author:wenlixu
 * Date:2019/4/10 13:06
 * Description:
 * Version:1.0
 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
@Component
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate template;

    @Override
    @Transactional(readOnly = true)
    public User Login(User user) throws UserNotFoundException, UserAlreadyLoginException {

        System.out.println("user:"+user);

        //判断用户是否登陆过
        JSONObject possibleUser =  JSON.parseObject(template.opsForValue().get("USER_TOKEN::" + user.getUsername()));
        if(null != possibleUser){
            //说明已经登录过
            System.out.println(possibleUser);
            throw new UserAlreadyLoginException("用户已经登录，请先退出后再登录！");
        }

        User returnUser = userMapper.selectByUsernameAndPassword(user);
        if(null == returnUser){
            throw new UserNotFoundException("用户名或密码错误！");
        }

        return returnUser;
    }


    @Override
    public void register(UserVO userVO) throws SmsCodeException, UsernameAlreadyExistException {

        String redisCode = template.opsForValue().get("PHONE_CODE:"+userVO.getPhone());
        if(!userVO.getCode().trim().equals(redisCode.trim())){
            throw new SmsCodeException("短信验证码错误");
        }

        User userForCheckUsername = userMapper.selectByUsername(userVO);
        if(null != userForCheckUsername){
            throw new UsernameAlreadyExistException("该用户名已存在");
        }

        userVO.setFlag(Constants.Status.ENABLE.getValue());

        userMapper.insertUser(userVO);
    }
}
