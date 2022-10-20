package com.ttn.HelloWorldService;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld{
    private String message;
    public HelloWorld(){

    }
    public HelloWorld(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
