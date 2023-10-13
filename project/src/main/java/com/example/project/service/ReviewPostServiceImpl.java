package com.example.project.service;

import com.example.project.dto.request.ReviewPostDTO;
import com.example.project.mapper.ReviewPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewPostServiceImpl implements ReviewPostService {


    @Override
    public void insertReviewPost(ReviewPostDTO reviewPostDTO) {

    }

    @Override
    public ReviewPostDTO getReviewPost(Long review_seq) {
        return null;
    }



}
