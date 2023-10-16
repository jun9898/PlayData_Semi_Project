package com.example.project.controller.api;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class BoardApiController {

    private final BoardService service;

    @GetMapping("/feed")
    public List<ContentDTO> requestContent(@ModelAttribute RequestContentDTO dto) {
        return service.getContentList(dto);
    }
}
