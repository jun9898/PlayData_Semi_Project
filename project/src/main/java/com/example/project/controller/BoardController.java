package com.example.project.controller;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    @RequestMapping("/{name}")
    public String TestPath(@PathVariable("name") String name){
        System.out.println("board/"+name);
        return "board/"+name;
    }

    @GetMapping("/feed/request")
    @ResponseBody
    public List<ContentDTO> requestContent(RequestContentDTO dto) {
        return service.getContentList(dto);
    }
}
