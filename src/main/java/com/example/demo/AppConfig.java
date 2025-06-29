package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("fb")
    public MyFirstClass myF(){
        return new MyFirstClass("First Bean");
    }

    @Bean
    @Qualifier("sb")
    public MyFirstClass myS(){
        return new MyFirstClass("Second Bean");
    }

    @Bean
    @Qualifier("tb")
    public MyFirstClass myT(){
        return new MyFirstClass("Third Bean");
    }
}
