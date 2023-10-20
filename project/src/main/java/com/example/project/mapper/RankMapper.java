package com.example.project.mapper;

import com.example.project.dto.response.rank.MarketRankDTO;
import com.example.project.dto.response.rank.ReviewRankDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankMapper {
    void insertRank(ReviewRankDTO create);
    List<ReviewRankDTO> reviewRank(ReviewRankDTO dto);
    List<MarketRankDTO> marketRank(MarketRankDTO dto);
    void updateRank(ReviewRankDTO update);
    void deleteRank(Long review_seq);
}
