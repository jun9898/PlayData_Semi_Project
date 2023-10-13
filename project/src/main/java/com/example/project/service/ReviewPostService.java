package com.example.project.service;

import com.example.project.dto.request.ReviewPostDTO;


public interface ReviewPostService {

    void insertReviewPost(ReviewPostDTO reviewPostDTO);

    ReviewPostDTO getReviewPost(Long review_seq);

}