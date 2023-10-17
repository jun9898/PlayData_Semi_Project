
package com.example.project.controller.view;

//import com.example.project.service.MemberService;

import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/user")
@SessionAttributes("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/profile")
    public String mypageView(){
        return "user/mypage";
    }

    @GetMapping("/profile/delete")
    public String deleteUser(Long user_seq){
        service.deleteUser(user_seq);
        return "redirect:/content/feed";
    }



}
