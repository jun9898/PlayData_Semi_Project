package com.example.project.service;

import com.example.project.dto.request.user.ReviewPostDTO;
import com.example.project.dto.response.user.ReviewPostReadDTO;


public interface ReviewPostService {

    void insertReviewPost(ReviewPostDTO reviewPostDTO);

    ReviewPostReadDTO getReviewPost(Long review_seq);

}