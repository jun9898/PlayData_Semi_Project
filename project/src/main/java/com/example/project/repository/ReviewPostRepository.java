package com.example.project.repository;

import com.example.project.dto.request.ReviewPostDTO;


public interface ReviewPostRepository {

    void write(ReviewPostDTO dto);
    ReviewPostDTO read(Long review_seq);
}
