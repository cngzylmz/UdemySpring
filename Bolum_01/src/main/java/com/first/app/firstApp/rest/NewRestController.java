package com.first.app.firstApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }

}
