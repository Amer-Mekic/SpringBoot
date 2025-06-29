package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private final MyFirstClass mfc;

    private Environment e;

    @Value("${my.name}")
    private String s;
    @Value("${num}")
    private String num;

    public FirstService(@Qualifier("tb") MyFirstClass mf)
    {
        this.mfc=mf;
    }

    @Autowired
    public void setEnvironment(Environment env){
        this.e = env;
    }

    public String getJavaVersion(){
        return e.getProperty("os.name");
    }

    public String tellStory(){
        return "dependency is saying "+mfc.sayHello();
    }

    public String getS() {
        return s;
    }

    public String getNum() {
        return num;
    }
}
