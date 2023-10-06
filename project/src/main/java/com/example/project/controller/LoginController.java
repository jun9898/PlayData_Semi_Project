package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login() {
        return "login/login";
    }

    @GetMapping("/login/join")
    public String join() {
        return "login/join";
    }

    @GetMapping("/login/id-pw-inquiry")
    public String inquiry() {
        return "login/inquiry";
    }

}
