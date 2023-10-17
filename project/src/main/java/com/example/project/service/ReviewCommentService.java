package com.example.project.service;

import com.example.project.dto.request.review.ReviewCommentDTO;
import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ReviewCommentService {
    void insertReviewComment(ReviewCommentDTO reviewCommentDTO);
    List<ReviewCommentReadDTO> getReviewComment(Long comment_seq);
    void deleteReviewComment(Long comment_seq);
    void updateReviewComment(Long commentSeq, ReviewCommentDTO updatedCommentDTO);
    void insertReviewCommentRecommand(ReviewCommentRecommandDTO reviewCommentRecommandDTO);
    int checkIfAlreadyRecommanded(ReviewCommentRecommandDTO reviewCommentRecommandDTO);
    void deleteReviewCommentRecommand(ReviewCommentRecommandDTO reviewCommentRecommandDTO);
}