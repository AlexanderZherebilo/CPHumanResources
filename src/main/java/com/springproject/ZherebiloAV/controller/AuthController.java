package com.springproject.ZherebiloAV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/authorization")
    public String authorization() {
        return "authorization";
    }
}
