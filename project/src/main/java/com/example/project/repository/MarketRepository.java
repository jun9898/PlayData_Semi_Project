package com.example.project.repository;

import com.example.project.dto.request.ReviewViewDTO;
import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;

import java.util.List;

public interface MarketRepository {
    void create(ShopContentBoardDTO dto);
    ShopContentBoardDTO getMarketInfo(Long market_seq);
    List<ReviewViewDTO> list(Long market_Seq);

    String starAVG(Long market_Seq);
    int update(ShopContentBoardDTO dto);
    int delete(Long market_seq);


    ReviewPostReadDTO getFile(Long market_seq);
}
