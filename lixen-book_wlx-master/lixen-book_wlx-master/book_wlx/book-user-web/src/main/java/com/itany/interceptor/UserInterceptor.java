package com.itany.interceptor;

import com.itany.ApplicationContextHolder;
import com.itany.utils.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author:wenlixu
 * Date:2019/4/10 18:19
 * Description:
 * Version:1.0
 */
public class UserInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取StringRedisTemplate对象
        StringRedisTemplate template = ApplicationContextHolder.getBean(StringRedisTemplate.class);

        boolean flag = false;

        Cookie[] cks = request.getCookies();
        if(null != cks){
            for(int i = 0;i<cks.length;i++){
                Cookie ck = cks[i];
                if("TT_TOKEN".equals(ck.getName())){

                    //根据key从数据库中查询缓存的值
                    String userMsg = template.opsForValue().get("USER_TOKEN::"+ck.getValue());

                    //有Cookie但是redis缓存中不存在用户信息
                    if(StringUtils.isBlank(userMsg)){
                        response.sendRedirect("http://localhost:9003/user/login");
                    }

                    //有Cookie但是redis缓存不存在用户信息
                    flag = true;
                }
            }
        }
        return flag;
    }
}
