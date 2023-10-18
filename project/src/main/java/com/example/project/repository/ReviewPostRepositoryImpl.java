package com.example.project.repository;

import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
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

    @Override
    public void update(ReviewPostDTO dto) {
    }

    @Override
    public void delete(Long review_seq) {
        mapper.deleteReviewPost(review_seq);
    }

    @Override
    public void writepostcommand(ReviewRecommandDTO dto) {
        mapper.insertReviewRecommand(dto);
    }

    @Override
    public int checkIfAlreadyPostRecommanded(ReviewRecommandDTO dto) {
        return mapper.checkIfAlreadyPostRecommanded(dto);
    }

    @Override
    public void deletepostcommand(ReviewRecommandDTO dto) {
        mapper.deleteReviewRecommand(dto);
    }

}
