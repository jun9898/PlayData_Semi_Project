package com.example.project.controller.api;

import com.example.project.dto.TagDto;
import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.map.MarketReviewDTO;
import com.example.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/map")
    public List<MarketReviewDTO> searchMarketAndReview(@RequestParam(required=false) SearchMapDTO dto){
        return service.getMarketAndReviewList(dto);
    }
    @GetMapping("/tag")
    public List<TagDto> getTagList(){
        return service.getTagList();
    }
}
