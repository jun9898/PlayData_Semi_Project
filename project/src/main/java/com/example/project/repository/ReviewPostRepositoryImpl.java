package com.example.project.repository;

import com.example.project.dto.request.ReviewPostDTO;
import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.LoginResultDTO;
import com.example.project.entity.UserEntity;
import com.example.project.mapper.ReviewPostMapper;
import com.example.project.mapper.UserMapper;
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
    public ReviewPostDTO read(Long review_seq){
       return  mapper.getReviewPost(review_seq);
    }

}
