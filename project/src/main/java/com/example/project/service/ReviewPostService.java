package com.example.project.service;

import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;


public interface ReviewPostService {

    void insertReviewPost(ReviewPostDTO reviewPostDTO);

    ReviewPostReadDTO getReviewPost(Long review_seq);

}