package com.example.project.repository;

import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;


public interface ReviewPostRepository {

    void write(ReviewPostDTO dto);
    ReviewPostReadDTO read(Long review_seq);



}
