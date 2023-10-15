
package com.example.project.controller.view;

//import com.example.project.service.MemberService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @GetMapping("/profile")
    public String mypageView(){
        return "user/mypage";
    }



}
