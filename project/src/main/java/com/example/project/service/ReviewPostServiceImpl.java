package com.example.project.service;

import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
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

    @Override
    public void updateReviewPost(ReviewPostDTO reviewPostDTO) {

    }

    @Override
    public void deleteReviewPost(Long review_seq) {
        ReviewPostReadDTO existingPost = repository.read(review_seq);
        if (existingPost != null) {
            repository.delete(review_seq);
        } else {

            System.out.println("삭제할 게시물이 존재하지 않습니다.");
        }
    }

    @Override
    public void insertReviewRecommand(ReviewRecommandDTO reviewRecommandDTO) {
        repository.writepostcommand(reviewRecommandDTO);
    }

    @Override
    public int checkIfAlreadyPostRecommanded(ReviewRecommandDTO reviewRecommandDTO) {
        return  repository.checkIfAlreadyPostRecommanded(reviewRecommandDTO);
    }

    @Override
    public void deleteReviewRecommand(ReviewRecommandDTO reviewRecommandDTO) {
        repository.deletepostcommand(reviewRecommandDTO);
    }

}

