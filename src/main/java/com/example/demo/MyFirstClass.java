package com.example.demo;

import org.springframework.stereotype.Service;

public class MyFirstClass {

    private final String myVar;
    public MyFirstClass(String myVar){
        this.myVar = myVar;
    }
    public String sayHello(){
        return "Hello from my first class! myVar = "+myVar;
    }
}
