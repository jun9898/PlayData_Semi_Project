package com.example.project.repository;

import com.example.project.dto.TagDto;
import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.map.MarketDocumentDTO;
import com.example.project.dto.response.map.MarketReviewDTO;
import com.example.project.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{

    private final BoardMapper boardMapper;

    @Override
    public List<ContentDTO> getContentList(RequestContentDTO dto) {
        return boardMapper.getContentList(dto);
    }

    @Override
    public List<ContentDTO> getFollowContentList(RequestContentDTO dto) {
        return boardMapper.getFollowContentList(dto);
    }

    @Override
    public int createTmpMarketList() {
        return boardMapper.createTmpMarketList();
    }

    @Override
    public int insertTmpMarketList(List<MarketDocumentDTO> dto) {
        return boardMapper.insertTmpMarketList(dto);
    }

    @Override
    public int upsertMarketList(List<MarketDocumentDTO> dto) {
        return boardMapper.upsertMarketList(dto);
    }

    @Override
    public int dropTmpMarketList() {
        return boardMapper.dropTmpMarketList();
    }

    @Override
    public List<MarketReviewDTO> getMarketAndReviewList(SearchMapDTO dto) {
        return boardMapper.getMarketAndReviewList(dto);
    }

    @Override
    public List<TagDto> getTagList() {
        return boardMapper.getTagList();
    }


}
