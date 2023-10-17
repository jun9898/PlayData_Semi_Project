package com.example.project.mapper;

import com.example.project.dto.request.review.ReviewCommentDTO;
import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewCommentMapper {

    void insertReviewComment(ReviewCommentDTO reviewCommentDTO);
    List<ReviewCommentReadDTO> getReviewComment(Long review_seq);
    void deleteReviewComment(Long comment_seq);
    void updateReviewComment(Long comment_seq, @Param("comment") ReviewCommentDTO commentDTO);
    void insertReviewCommentRecommand(ReviewCommentRecommandDTO reviewCommentRecommandDTO);
    int checkIfAlreadyRecommanded(ReviewCommentRecommandDTO reviewCommentRecommandDTO);
    void deleteRecommand(ReviewCommentRecommandDTO reviewCommentRecommandDTO);
}
