package com.example.project.mapper;

import com.example.project.dto.request.ReviewViewDTO;
import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketMapper {
    void insertMarket(ShopContentBoardDTO market);
    ShopContentBoardDTO contentMarket(Long market_seq);
    ShopContentBoardDTO selectMarketSeq(String name);
    List<ReviewViewDTO> commentList(Long market_seq);

    String starAVG(Long market_seq);

    ReviewPostReadDTO getFile(Long market_seq);
    void updateMarket(ShopContentBoardDTO update);
    void deleteMarket(Long market_seq);



}
