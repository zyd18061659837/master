package com.itany.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author:wenlixu
 * Date:2019/4/13 13:36
 * Description:
 * Version:1.0
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/showBookList").setViewName("bookList");
    }
}
