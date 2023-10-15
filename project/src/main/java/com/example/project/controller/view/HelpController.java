package com.example.project.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/board")
@SessionAttributes("user")
public class HelpController {

    @GetMapping("/notice")
    public String noticeView() {

        return "help/notice";
    }

    @GetMapping("/qna")
    public String qnaView() {

        return "help/qna";
    }

}
