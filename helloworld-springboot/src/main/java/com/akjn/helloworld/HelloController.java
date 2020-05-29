package com.akjn.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHelloWorld(){
        return "Hello World!";
    }

    @RequestMapping("/")
    public String sayHelloWorld2(){
        return "Homepage!";
    }

}
