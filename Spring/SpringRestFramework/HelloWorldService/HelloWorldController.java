package com.ttn.HelloWorldService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    HelloWorld helloWorld;

    @GetMapping(path ="/api/message")
    public HelloWorld helloWorldMsg(){
        return new HelloWorld("Welcome to springboot.");
    }
}
