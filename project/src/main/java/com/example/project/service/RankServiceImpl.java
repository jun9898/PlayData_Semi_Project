package com.example.project.service;

import com.example.project.dto.response.rank.MarketRankDTO;
import com.example.project.dto.response.rank.ReviewRankDTO;
import com.example.project.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService{
    private final RankRepository repository;

    @Override
    public int create(ReviewRankDTO create) {
        return 0;
    }

    @Override
    public List<ReviewRankDTO> getReviewRankingInfo(ReviewRankDTO dto) {
        System.out.println("dto service1=++++++++++++++++++++++++++++++++++++ " + dto);
        List<ReviewRankDTO> list = repository.getReviewRankingInfo(dto);
        System.out.println("dto service2=++++++++++++++++++++++++++++++++++++ " + list);
        return list;
    }

    @Override
    public List<MarketRankDTO> getMarketRankingInfo(MarketRankDTO dto) {
        System.out.println("dto service1=================================== " + dto);
        List<MarketRankDTO> list = repository.getMarketRankingInfo(dto);
        System.out.println("list service2=========================================== " + list);
        return list;
    }

    @Override
    public int update(ReviewRankDTO update) {
        return 0;
    }

    @Override
    public int delete(Long review_seq) {
        return 0;
    }
}
