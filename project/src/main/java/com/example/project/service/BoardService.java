package com.example.project.service;

import com.example.project.dto.TagDto;
import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.map.MarketReviewDTO;

import java.util.List;

public interface BoardService {

    List<ContentDTO> getContentList(RequestContentDTO dto);
    List<MarketReviewDTO> getMarketAndReviewList(SearchMapDTO dto);

    List<TagDto> getTagList();

}
