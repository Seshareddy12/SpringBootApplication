package com.luv2code.springboot.InventorySystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping
    public String redirect(){
        return "redirect:/category/list";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "error2";
    }
}
