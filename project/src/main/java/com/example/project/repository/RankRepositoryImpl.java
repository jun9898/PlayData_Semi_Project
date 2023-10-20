package com.example.project.repository;

import com.example.project.dto.response.rank.MarketRankDTO;
import com.example.project.dto.response.rank.ReviewRankDTO;
import com.example.project.mapper.RankMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankRepositoryImpl implements RankRepository {
    private final RankMapper mapper;

    @Override
    public int create(ReviewRankDTO create) {
        return 0;
    }

    @Override
    public List<ReviewRankDTO> getReviewRankingInfo(ReviewRankDTO dto) {
        System.out.println("dto rep1================================== " + dto);
        List<ReviewRankDTO> list = mapper.reviewRank(dto);
        System.out.println("list rep2================================== " + list);
        return list;

    }

    @Override
    public List<MarketRankDTO> getMarketRankingInfo(MarketRankDTO dto) {
        System.out.println("dto rep1===================================== " + dto);
        List<MarketRankDTO> list = mapper.marketRank(dto);
        System.out.println("list rep2================================================= " + list);
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
