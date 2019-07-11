package com.itany.conf;

import com.itany.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author:wenlixu
 * Date:2019/4/10 13:28
 * Description:
 * Version:1.0
 */
@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/register")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/static/**");
    }
}
