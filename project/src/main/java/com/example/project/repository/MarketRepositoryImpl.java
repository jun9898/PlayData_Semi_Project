package com.example.project.repository;

import com.example.project.dto.request.ReviewViewDTO;
import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.mapper.MarketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarketRepositoryImpl implements MarketRepository{
    private final MarketMapper mapper;


    @Override
    public void create(ShopContentBoardDTO dto) {

        mapper.insertMarket(dto);
    }

    @Override
    public ShopContentBoardDTO getMarketInfo(Long market_seq) {

       ShopContentBoardDTO dto = mapper.contentMarket(market_seq);
        System.out.println("dto ====================================================== " + dto);
       return dto;
    }



    @Override
    public List<ReviewViewDTO> list(Long market_seq){
       // System.out.println("==========================repositoryimpl ========================================== "+market_seq);
        List<ReviewViewDTO> dto =  mapper.commentList(market_seq);
        System.out.println("dto = " + dto);
        return dto;
    }

    @Override
    public String starAVG(Long market_Seq) {
        System.out.println("market_Seq ====================================== " + market_Seq);
        String dto = mapper.starAVG(market_Seq);
        System.out.println("dto = " + dto);
        return dto;
    }

    @Override
    public int update(ShopContentBoardDTO dto) {
        return 0;
    }

    @Override
    public int delete(Long market_seq) {
        return 0;
    }

    @Override
    public ReviewPostReadDTO getFile(Long market_seq) {
        return mapper.getFile(market_seq);
    }


}
