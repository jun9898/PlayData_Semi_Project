package com.example.project.service;

import com.example.project.dto.request.review.ReviewCommentDTO;
import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import com.example.project.repository.ReviewCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReviewCommentServiceImpl implements ReviewCommentService {
    private final ReviewCommentRepository repository;

    @Override
    public void insertReviewComment(ReviewCommentDTO reviewCommentDTO) {
        repository.write(reviewCommentDTO);
    }
    @Override
    public List<ReviewCommentReadDTO> getReviewComment(Long review_seq) {
        return repository.read(review_seq);
    }
    @Override
    public void deleteReviewComment(Long comment_seq) {
        repository.delete(comment_seq);
    }
    @Override
    public void updateReviewComment(Long comment_seq, ReviewCommentDTO updatedCommentDTO) {
        repository.updateReviewComment(comment_seq, updatedCommentDTO);
    }
    @Override
    public void insertReviewCommentRecommand(ReviewCommentRecommandDTO reviewCommentRecommandDTO) {
        repository.writecommand(reviewCommentRecommandDTO);
    }
    @Override
    public int checkIfAlreadyRecommanded(ReviewCommentRecommandDTO reviewCommentRecommandDTO) {
        return  repository.checkIfAlreadyRecommanded(reviewCommentRecommandDTO);
    }
    @Override
    public void deleteReviewCommentRecommand(ReviewCommentRecommandDTO reviewCommentRecommandDTO) {
        repository.deletecommand(reviewCommentRecommandDTO);
    }


}

