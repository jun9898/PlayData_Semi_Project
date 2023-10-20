package com.example.project.repository;

import com.example.project.dto.response.rank.MarketRankDTO;
import com.example.project.dto.response.rank.ReviewRankDTO;

import java.util.List;

public interface RankRepository {
    int create(ReviewRankDTO create);
    List<ReviewRankDTO> getReviewRankingInfo(ReviewRankDTO dto);
    List<MarketRankDTO> getMarketRankingInfo(MarketRankDTO dao);
    int update(ReviewRankDTO update);
    int delete(Long review_seq);
}
