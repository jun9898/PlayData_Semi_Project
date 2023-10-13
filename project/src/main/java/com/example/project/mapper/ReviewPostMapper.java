package com.example.project.mapper;

import com.example.project.dto.request.ReviewPostDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewPostMapper {

    void insertReviewPost(ReviewPostDTO reviewPostDTO);
    ReviewPostDTO getReviewPost(Long review_seq);

}
