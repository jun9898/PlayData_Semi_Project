package com.example.project.helptest;

import com.example.project.dto.request.help.NoticeDTO;
import com.example.project.dto.request.help.QnaDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.response.help.NoticeReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.service.NoticeService;
import com.example.project.service.ReviewPostService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class NoticeTest {
    @Autowired
    private NoticeService service;
    @Test
    @Disabled
    @Rollback(value = false)
    public void writeTest() {
        // 글쓰기
        NoticeDTO write = new NoticeDTO();
        write.setTitle("testtitle1");
        write.setContent("testcontent1");
        write.setCreate_admin_seq(1L);
        write.setView_count(1L);
        service.insertNotice(write);
    }

    @Test
    @Disabled
    @Rollback(value = false)
    public void ReadTest(){
        System.out.println(service.getNotice(10L).toString());
    }



    @Test
    @Disabled
    @Rollback(value = false)
    public void deleteTest() {
        // 게시물 삭제
        Long reviewSeq = 9L; // 삭제할 게시물의 고유 식별자
        service.deleteNotice(reviewSeq);
    }

    @Test
    @Rollback(value = false)
    public void writeQnaTest() {
        // 글쓰기
        QnaDTO writeqna = new QnaDTO();
        writeqna.setTitle("testtitle2");
        writeqna.setContent("testcontent2");
        writeqna.setUser_seq(1L);
        writeqna.setAnswer("answertest");
        service.insertQna(writeqna);
    }


//    @Test
//    @Disabled
//    @Rollback(value = false)
//    public void updateTest() {
//        // 수정할 게시물의 정보 가져오기
//        NoticeReadDTO existingPost = service.getNotice(10L);
//
//        if (existingPost != null) {
//            // 수정할 정보 설정
//            ReviewPostDTO updateDTO = new ReviewPostDTO();
//            updateDTO.setUser_seq(existingPost.getUser_seq());
//            updateDTO.setMarket_seq(existingPost.getMarket_seq());
//            updateDTO.setTitle("Updated Title");
//            updateDTO.setContent("Updated Content");
//            updateDTO.setView_count(existingPost.getView_count());
//            updateDTO.setStar(existingPost.getStar());
//            updateDTO.setImg_1(existingPost.getImg_1());
//            updateDTO.setImg_2(existingPost.getImg_2());
//            updateDTO.setImg_3(existingPost.getImg_3());
//            updateDTO.setImg_4(existingPost.getImg_4());
//            updateDTO.setImg_5(existingPost.getImg_5());
//
//            // 게시물 업데이트
//            service.updateReviewPost(updateDTO);
//
//            // 업데이트 후의 결과를 가져와서 확인할 수도 있습니다.
//            ReviewPostReadDTO updatedPost = service.getNotice(existingPost.get());
//            System.out.println(updatedPost.toString());
//        } else {
//            System.out.println("수정할 게시물이 존재하지 않습니다.");
//        }
//    }






}
