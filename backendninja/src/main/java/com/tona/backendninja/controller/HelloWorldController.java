package com.tona.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tona created on 09/03/2018 for backendninja.
 */
@Controller
@RequestMapping("/say")
public class HelloWorldController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "hello-world";
    }
}
