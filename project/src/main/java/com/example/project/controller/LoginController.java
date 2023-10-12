package com.example.project.controller;

import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.entity.UserEntity;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//    @PostMapping("/")
//    public String login(LoginUserDTO dto, Model model) {
//        UserEntity user = service.login(dto);
//        String view = "";
//        if(user!=null) {//로그인 성공
//            model.addAttribute("user",user);
//            view = "board/feed";
//        }else { //로그인실패시 어떤 처리를 할지 생각해봐야 함
//            view = "redirect:/";
//        }
//        return view;
//    }

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

}
