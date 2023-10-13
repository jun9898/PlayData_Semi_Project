package com.example.project.mapper;

import com.example.project.dto.request.user.ReviewPostDTO;
import com.example.project.dto.response.user.ReviewPostReadDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewPostMapper {

    void insertReviewPost(ReviewPostDTO reviewPostDTO);
    ReviewPostReadDTO getReviewPost(Long review_seq);

}
