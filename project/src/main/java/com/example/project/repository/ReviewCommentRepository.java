package com.example.project.repository;

import com.example.project.dto.request.review.ReviewCommentDTO;
import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;

import java.util.List;


public interface ReviewCommentRepository {

    void write(ReviewCommentDTO dto);
    List<ReviewCommentReadDTO> read(Long review_seq);
    void delete(Long comment_seq);
    void updateReviewComment(Long comment_seq,ReviewCommentDTO updatedCommentDTO);
    void writecommand(ReviewCommentRecommandDTO dto);
    int checkIfAlreadyRecommanded(ReviewCommentRecommandDTO dto);
    void deletecommand(ReviewCommentRecommandDTO dto);

}
