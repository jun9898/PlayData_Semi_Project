package com.example.project.service;


import com.example.project.dto.request.ReviewViewDTO;
import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketServiceImpl implements MarketService{
    private final MarketRepository repository;



    @Override
    public void create(ShopContentBoardDTO market) {
        repository.create(market);
    }

    @Override
    public ShopContentBoardDTO getMarketInfo(Long market_seq) {
        //System.out.println("==========================Serviceimpl ========================================== "+market_seq);
        ShopContentBoardDTO dto = repository.getMarketInfo(market_seq);
        System.out.println("dto = " + dto);
        return dto;
    }

    @Override
    public String starAVG(Long market_seq) {
        System.out.println("market_seq ==================================================== " + market_seq);
        String dto =repository.starAVG(market_seq);
        System.out.println("dto = " + dto);
        return dto;
    }

    @Override
    public ReviewPostReadDTO getFile(Long market_seq) {
        return repository.getFile(market_seq);
    }

    @Override
    public List<ReviewViewDTO> list(Long market_seq) {
        //System.out.println("==========================Serviceimpl ========================================== "+market_seq);
        List<ReviewViewDTO> dto = repository.list(market_seq);
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


}
