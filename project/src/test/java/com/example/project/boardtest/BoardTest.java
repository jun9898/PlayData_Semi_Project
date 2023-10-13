package com.example.project.boardtest;

import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.service.ReviewPostService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class BoardTest {
    @Autowired
    private ReviewPostService service;
    @Test
    @Disabled
    @Rollback(value = false)
    public void writeTest() {

        // 글쓰기
        ReviewPostDTO write = new ReviewPostDTO();
        write.setUser_seq(1L);
        write.setMarket_seq(1L);
        write.setTitle("test");
        write.setContent("test");
        write.setView_count(1L);
        write.setStar(1L);
        write.setImg1("");
        write.setImg2("");
        write.setImg3("");
        write.setImg4("");
        write.setImg5("");
        service.insertReviewPost(write);
    }
    @Test
    @Rollback(value = false)
    public void ReadTest(){

        System.out.println(service.getReviewPost(5L).toString());

    }
}
