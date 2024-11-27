package com.green.secondservice.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("second-service")
public class SecondController {

    private final Environment environment;

    public SecondController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("test")
    public String test() {
        System.out.println("this server" + environment.getProperty("local.server.port"));
        return "test";
    }
}
