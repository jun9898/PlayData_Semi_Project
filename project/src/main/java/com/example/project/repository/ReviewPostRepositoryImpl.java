package com.example.project.repository;

import com.example.project.dto.request.user.ReviewPostDTO;
import com.example.project.dto.response.user.ReviewPostReadDTO;
import com.example.project.mapper.ReviewPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewPostRepositoryImpl implements ReviewPostRepository{
    private final ReviewPostMapper mapper;


    @Override
    public void write(ReviewPostDTO dto){
        mapper.insertReviewPost(dto);
    }
    @Override
    public ReviewPostReadDTO read(Long review_seq){
       return mapper.getReviewPost(review_seq);
    }

}
