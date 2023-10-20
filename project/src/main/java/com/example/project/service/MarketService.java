package com.example.project.service;

import com.example.project.dto.request.ReviewViewDTO;
import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;

import java.util.List;

public interface MarketService {
    //insert
    void create(ShopContentBoardDTO dto);

    ShopContentBoardDTO getMarketInfo(Long market_seq);

    //상세조회
    List<ReviewViewDTO> list(Long market_seq);

    String starAVG(Long market_seq);

    ReviewPostReadDTO getFile(Long market_seq);


    int update(ShopContentBoardDTO dto);

    int delete(Long market_seq);
}






