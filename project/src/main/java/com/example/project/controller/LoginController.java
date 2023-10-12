package com.example.project.controller;

import com.example.project.Exception.LoginFailException;
import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequiredArgsConstructor
@SessionAttributes("user")
public class LoginController {

    private final UserService service;

    @GetMapping("/")
    public String loginView() {
        return "login/login";
    }

    @PostMapping("/")
    public String login(LoginUserDTO dto, Model model) {
        String user = service.login(dto);
        return "test";
    }

    @GetMapping("/login/join")
    public String join() {
        return "login/join";
    }

    @PostMapping("/login/join")
    public String createUser(CreateUserDTO requestCreateUserDTO) {
        service.join(requestCreateUserDTO);
        return "board/feed";
    }

    @GetMapping("/login/id-pw-inquiry")
    public String inquiry() {
        return "login/inquiry";
    }

    @ExceptionHandler(LoginFailException.class)
    public String ExceptionTest() {
        return "test";
    }
}
