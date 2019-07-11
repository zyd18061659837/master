package com.itany.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author:wenlixu
 * Date:2019/4/16 21:48
 * Description:
 * Version:1.0
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/showindex").setViewName("index");
        registry.addViewController("/showsuccess").setViewName("success");
    }
}
