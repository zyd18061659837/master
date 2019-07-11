package com.itany.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author:wenlixu
 * Date:2019/3/27 13:52
 * Description:
 * Version:1.0
 */
@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/bookList").setViewName("booklist");
        registry.addViewController("/supplierExamine").setViewName("supplier_examine");
        registry.addViewController("/supplierPlatform").setViewName("supplier_platform");
        registry.addViewController("/permission").setViewName("permission");
        registry.addViewController("/role").setViewName("role");
        registry.addViewController("/manager").setViewName("manager");


    }
}
