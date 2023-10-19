package com.example.project.mapper;

import com.example.project.dto.TagDto;
import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.map.MarketDocumentDTO;
import com.example.project.dto.response.map.MarketReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<ContentDTO> getContentList(RequestContentDTO dto);
    List<ContentDTO> getFollowContentList(RequestContentDTO dto);
    int upsertMarketList(List<MarketDocumentDTO> dto);
    List<MarketReviewDTO> getMarketAndReviewList(SearchMapDTO dto);

    List<TagDto> getTagList();
}
