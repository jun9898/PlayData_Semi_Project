package com.example.project.repository;

import com.example.project.dto.request.review.ReviewCommentDTO;
import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.mapper.ReviewCommentMapper;
import com.example.project.mapper.ReviewPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewCommentRepositoryImpl implements ReviewCommentRepository{
    private final ReviewCommentMapper mapper;


    @Override
    public void write(ReviewCommentDTO dto){
        mapper.insertReviewComment(dto);
    }
    @Override
    public List<ReviewCommentReadDTO> read(Long review_seq){
       return mapper.getReviewComment(review_seq);
    }
    @Override
    public void delete(Long comment_seq){
        mapper.deleteReviewComment(comment_seq);
    }
    @Override
    public void updateReviewComment(Long comment_seq, ReviewCommentDTO updatedCommentDTO) {
        System.out.println(comment_seq);
        System.out.println(updatedCommentDTO);
        mapper.updateReviewComment(comment_seq, updatedCommentDTO);
    }

    @Override
    public void writecommand(ReviewCommentRecommandDTO dto) {
//        System.out.println(dto);
        mapper.insertReviewCommentRecommand(dto);
    }
    @Override
    public int checkIfAlreadyRecommanded(ReviewCommentRecommandDTO dto) {
        return mapper.checkIfAlreadyRecommanded(dto);
    }
    @Override
    public void deletecommand(ReviewCommentRecommandDTO dto) {
        mapper.deleteRecommand(dto);
    }

}
