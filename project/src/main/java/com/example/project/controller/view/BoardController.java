package com.example.project.controller.view;

import com.example.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/content")
@SessionAttributes("user")
public class BoardController {

    private final BoardService service;

    @GetMapping("/feed")
    public String feedView(){
        return "board/feed";
    }

    @GetMapping("/map")
    public String mapView(){
        return "board/map";
    }

}
