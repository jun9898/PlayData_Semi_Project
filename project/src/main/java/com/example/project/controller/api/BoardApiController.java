package com.example.project.controller.api;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class BoardApiController {

    private final BoardService service;

    @GetMapping("/feed")
    @ResponseBody
    public List<ContentDTO> requestContent(RequestContentDTO dto) {
        return service.getContentList(dto);
    }
}
