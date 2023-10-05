package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RankController {

    @RequestMapping("/{name}")
    public String TestPath(@PathVariable("name") String name){
        return "rank/"+name;
    }

}
