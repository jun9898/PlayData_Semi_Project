package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {


    @RequestMapping("/{name}")
    public String TestPath(@PathVariable("name") String name){
        System.out.println("board/"+name);
        return "board/"+name;
    }


}
