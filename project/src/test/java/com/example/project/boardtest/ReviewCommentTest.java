package com.example.project.boardtest;

import com.example.project.dto.request.review.ReviewCommentDTO;
import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.service.ReviewCommentService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class ReviewCommentTest {
    @Autowired
    private ReviewCommentService service;
    @Test
    @Rollback(value = false)
    @Disabled
    public void writeTest() {

        // 글쓰기
        ReviewCommentDTO write = new ReviewCommentDTO();
        write.setUser_seq(11L);
        write.setReview_seq(10L);
        write.setContent("베드");
        service.insertReviewComment(write);
    }
    @Test
    @Disabled
    @Rollback(value = false)
    public void ReadTest(){

        System.out.println(service.getReviewComment(10L).toString());

    }

    @Test
    @Rollback(value = false)
    @Disabled
    public void deleteTest() {

        Long commentSeq = 1L;
        service.deleteReviewComment(commentSeq);
    }

    @Test
    @Rollback(value = false)
    public void insertRecommandTest() {
        ReviewCommentRecommandDTO insert = new ReviewCommentRecommandDTO();
        insert.setComment_seq(23L);
        insert.setUser_seq(13L);
        service.insertReviewCommentRecommand(insert);
    }

}
