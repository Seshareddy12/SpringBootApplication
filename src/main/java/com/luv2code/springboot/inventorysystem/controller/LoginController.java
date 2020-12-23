package com.luv2code.springboot.inventorysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
