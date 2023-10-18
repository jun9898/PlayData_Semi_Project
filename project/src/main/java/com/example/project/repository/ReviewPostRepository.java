package com.example.project.repository;

import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;


public interface ReviewPostRepository {

    void write(ReviewPostDTO dto);
    ReviewPostReadDTO read(Long review_seq);
    void update(ReviewPostDTO dto); // 추가: 게시물 수정
    void delete(Long review_seq);
//    ReviewPostReadDTO updateViewCount(Long review_seq);
    void writepostcommand(ReviewRecommandDTO dto);
    int checkIfAlreadyPostRecommanded(ReviewRecommandDTO dto);
    void deletepostcommand(ReviewRecommandDTO dto);

}
