package com.example.project.boardtest;

import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
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

    @Rollback(value = false)
    public void writeTest() {

        // 글쓰기
        ReviewPostDTO write = new ReviewPostDTO();
        write.setUser_seq(17L);
        write.setMarket_seq(3L);
        write.setTitle("test3");
        write.setContent("test3");
        write.setView_count(1L);
        write.setStar(3L);
        write.setImg_1("review_5.jpeg");
        write.setImg_2("review_2.jpeg");
        write.setImg_3("review_3.jpeg");
        write.setImg_4("review_4.jpeg");
//        write.setImg_5("review_5.jpeg");
        service.insertReviewPost(write);
    }
    @Test
    @Disabled
    @Rollback(value = false)
    public void ReadTest(){
        System.out.println(service.getReviewPost(10L).toString());
    }



    @Test
    @Disabled
    @Rollback(value = false)
    public void deleteTest() {
        // 게시물 삭제
        Long reviewSeq = 9L; // 삭제할 게시물의 고유 식별자
        service.deleteReviewPost(reviewSeq);
    }


    @Test
    @Disabled
    @Rollback(value = false)
    public void updateTest() {
        // 수정할 게시물의 정보 가져오기
        ReviewPostReadDTO existingPost = service.getReviewPost(10L);

        if (existingPost != null) {
            // 수정할 정보 설정
            ReviewPostDTO updateDTO = new ReviewPostDTO();
            updateDTO.setUser_seq(existingPost.getUser_seq());
            updateDTO.setMarket_seq(existingPost.getMarket_seq());
            updateDTO.setTitle("Updated Title");
            updateDTO.setContent("Updated Content");
            updateDTO.setView_count(existingPost.getView_count());
            updateDTO.setStar(existingPost.getStar());
            updateDTO.setImg_1(existingPost.getImg_1());
            updateDTO.setImg_2(existingPost.getImg_2());
            updateDTO.setImg_3(existingPost.getImg_3());
            updateDTO.setImg_4(existingPost.getImg_4());
            updateDTO.setImg_5(existingPost.getImg_5());


            service.updateReviewPost(updateDTO);


            ReviewPostReadDTO updatedPost = service.getReviewPost(existingPost.getReview_seq());
            System.out.println(updatedPost.toString());
        } else {
            System.out.println("수정할 게시물이 존재하지 않습니다.");
        }
    }






}
