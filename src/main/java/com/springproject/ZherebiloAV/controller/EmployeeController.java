package com.springproject.ZherebiloAV.controller;

import com.springproject.ZherebiloAV.domain.User;
import com.springproject.ZherebiloAV.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employeeProfile")
    public String getProfile(Model model) {

        return "employeeProfile";
    }
}
