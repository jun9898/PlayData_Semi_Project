package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/help")
public class HelpController {


    @RequestMapping("/{name}")
    public String TestPath(@PathVariable("name") String name){
        System.out.println("help/"+name);
        return "help/"+name;
    }

}
