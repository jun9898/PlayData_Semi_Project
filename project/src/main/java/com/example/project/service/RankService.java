package com.example.project.service;

import com.example.project.dto.response.rank.MarketRankDTO;
import com.example.project.dto.response.rank.ReviewRankDTO;

import java.util.List;

public interface RankService {
    int create(ReviewRankDTO create);

    List<ReviewRankDTO> getReviewRankingInfo(ReviewRankDTO dto);
    List<MarketRankDTO> getMarketRankingInfo(MarketRankDTO dto);

    int update(ReviewRankDTO update);
    int delete(Long review_seq);
}
