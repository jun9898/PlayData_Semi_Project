package com.example.project.service;

import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.repository.ReviewPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewPostServiceImpl implements ReviewPostService {
    private final ReviewPostRepository repository;

    @Override
    public void insertReviewPost(ReviewPostDTO reviewPostDTO) {
        repository.write(reviewPostDTO);
    }

    @Override
    public ReviewPostReadDTO getReviewPost(Long review_seq) {
        return repository.read(review_seq);
    }
}

