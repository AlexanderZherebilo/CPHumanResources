package com.springproject.ZherebiloAV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegController {

    @GetMapping("/registration")
    public String registration() { return "registration"; }
}
