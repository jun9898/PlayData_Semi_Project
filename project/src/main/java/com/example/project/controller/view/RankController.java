package com.example.project.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/content")
@SessionAttributes("user")
public class RankController {

    @GetMapping("/rank")
    public String rankView(){
        return "rank/rank";
    }

}
