package com.example.project.service;

import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;


public interface ReviewPostService {

    void insertReviewPost(ReviewPostDTO reviewPostDTO);

    ReviewPostReadDTO getReviewPost(Long review_seq);
    void updateReviewPost(ReviewPostDTO reviewPostDTO);
    void deleteReviewPost(Long review_seq);
    void insertReviewRecommand(ReviewRecommandDTO reviewRecommandDTO);
    int checkIfAlreadyPostRecommanded(ReviewRecommandDTO reviewRecommandDTO);
    void deleteReviewRecommand(ReviewRecommandDTO reviewRecommandDTO);
}