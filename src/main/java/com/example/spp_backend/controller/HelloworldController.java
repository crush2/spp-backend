package com.example.spp_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloworldController {
    @RequestMapping("/hello")
    public @ResponseBody
    String hello() {
        return "hello spring boot boom";
    }
}
