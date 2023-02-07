package com.example.budgetLesh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// configure MVC class thanks to annotation Configure and WebMvcConfigurer implementation
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // override addViewControllers method of WebMvcConfigurer with our view controllers
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
