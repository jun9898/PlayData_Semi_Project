package com.example.project.repository;

import com.example.project.dto.TagDto;
import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.map.MarketDocumentDTO;
import com.example.project.dto.response.map.MarketReviewDTO;

import java.util.List;

public interface BoardRepository {

    List<ContentDTO> getContentList(RequestContentDTO dao);
    List<ContentDTO> getFollowContentList(RequestContentDTO dao);
    int upsertMarketList(List<MarketDocumentDTO> dto);
    List<MarketReviewDTO> getMarketAndReviewList(SearchMapDTO dto);
    List<TagDto> getTagList();
}
