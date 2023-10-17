package com.example.project.controller.view;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.UserDTO;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequiredArgsConstructor
@SessionAttributes("user")
public class LoginController {

    private final UserService service;

    @GetMapping("/login")
    // 세션 여부를 조회하고 세션이 있다면 feed로 이동
    public String loginView(@SessionAttribute(name = "user", required = false) UserDTO session) {
//        무한루프돌아서 실행 안됨 좀 더 알아봐야할듯 - 해결 Session 이 UserDTO로 담기는데 LoginCheckInterceptor에서
//        String으로 리턴받으려고 해서 발생하는 문제였음
        if (session != null){
            return "redirect:/content/feed";
        } else {
            return "login/login";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginUserDTO loginUserDTO, Model model) {
        UserDTO user = service.login(loginUserDTO);
        model.addAttribute("user",user);
        return "redirect:/content/feed";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/login";
    }

    @GetMapping("/join")
    public String join() {
        return "login/join";
    }

    @PostMapping("/join")
    public String createUser(@ModelAttribute CreateUserDTO requestCreateUserDTO) {
        service.join(requestCreateUserDTO);
        return "redirect:/board/feed";
    }

    @GetMapping("/forget")
    public String inquiry() {
        return "login/inquiry";
    }



}
