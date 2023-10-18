package com.example.project.mapper;

import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewPostMapper {

    void insertReviewPost(ReviewPostDTO reviewPostDTO);
    ReviewPostReadDTO getReviewPost(Long review_seq);
    void updateReviewPost(ReviewPostReadDTO reviewPostReadDTO);
    void deleteReviewPost(Long review_seq);
//    ReviewPostReadDTO increaseViewCount(Long review_seq);
    void insertReviewRecommand(ReviewRecommandDTO reviewRecommandDTO);
    int checkIfAlreadyPostRecommanded(ReviewRecommandDTO reviewRecommandDTO);
    void deleteReviewRecommand(ReviewRecommandDTO reviewRecommandDTO);
}
