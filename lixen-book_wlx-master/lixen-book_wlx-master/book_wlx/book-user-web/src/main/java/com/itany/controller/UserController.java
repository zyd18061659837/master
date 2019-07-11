package com.itany.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itany.exception.SmsCodeException;
import com.itany.exception.UserAlreadyLoginException;
import com.itany.exception.UserNotFoundException;
import com.itany.exception.UsernameAlreadyExistException;
import com.itany.pojo.User;
import com.itany.user.api.UserService;
import com.itany.utils.HttpClientUtils;
import com.itany.vo.AjaxResult;
import com.itany.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Author:wenlixu
 * Date:2019/4/10 13:31
 * Description:
 * Version:1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Reference
    private UserService userService;

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/login")
    public AjaxResult login(User user, HttpServletResponse response) throws UserNotFoundException, UserAlreadyLoginException {
        System.out.println("controller_____________"+user);
        AjaxResult result = new AjaxResult();
        User returnUser = userService.Login(user);

        returnUser.setPassword(null);
        String token = returnUser.getUsername();


        //设置redis存储的key-value
        //key是"USER_TOKEN"+自定义token,设置redis数据过期时间是半小时！
        template.opsForValue().set("USER_TOKEN::"+token, JSON.toJSONString(returnUser),
                1800, TimeUnit.SECONDS);

        //设置Cookie
        Cookie ck = new Cookie("TT_TOKEN",token);
        ck.setPath("/");
        response.addCookie(ck);

        result.setSuccess(true);
        return result;
    }

    @RequestMapping("/getCode")
    public AjaxResult getCode(@RequestParam("phone") String phone){
        AjaxResult result = new AjaxResult();

        String verifyCode = String
                .valueOf(new Random().nextInt(899999) + 100000);

        //请求接口地址
        String url ="http://v.juhe.cn/sms/send";

        //请求参数
        Map params = new HashMap();

        //接收短信的手机号码
        params.put("mobile",phone);
        //短信模板ID，请参考个人中心短信模板设置
        params.put("tpl_id","147783");
        //变量名和变量值对
        params.put("tpl_value","%23code%23%3d"+verifyCode);
        //应用APPKEY(应用详细页查询)
        params.put("key","90f0ef65cb0167ee929dfa9ed51d158b");

        String response = HttpClientUtils.doPost(url, params);
        JSONObject object = JSON.parseObject(response);

        if(object.getInteger("error_code") == 0){
            System.out.println(object.get("result"));

            //将短信验证码存储到redis中
            template.opsForValue().set("PHONE_CODE:"+phone, verifyCode,
                    1800, TimeUnit.SECONDS);


            result.setSuccess(true);

        }else{
            System.out.println(object.get("error_code")+":"+object.get("reason"));
            result.setSuccess(false);
            result.setMsg(object.get("reason").toString());
        }

        return result;
    }

    @RequestMapping("/register")
    public AjaxResult register(UserVO userVO) throws SmsCodeException, UsernameAlreadyExistException {

        AjaxResult result = new AjaxResult();
        userService.register(userVO);
        result.setSuccess(true);
        return result;
    }



}
