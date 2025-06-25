package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private final MyFirstClass mfc;

    public FirstService(MyFirstClass mf)
    {
        this.mfc=mf;
    }

    public String tellStory(){
        return "dependency is saying "+mfc.sayHello();
    }
}
