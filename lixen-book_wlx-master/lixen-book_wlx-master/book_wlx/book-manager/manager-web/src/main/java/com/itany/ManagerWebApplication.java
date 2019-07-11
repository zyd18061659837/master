package com.itany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class ManagerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerWebApplication.class, args);
    }
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.addUrlMappings("/manager/*");
        return registration;
    }
}
