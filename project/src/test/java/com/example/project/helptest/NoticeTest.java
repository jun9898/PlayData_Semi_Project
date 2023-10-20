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
        // 공지사항 글쓰기
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
    @Rollback(value = false)
    public void writeQnaTest() {
        // qna글쓰기
        QnaDTO writeqna = new QnaDTO();
        writeqna.setTitle("testtitle2");
        writeqna.setContent("testcontent2");
        writeqna.setUser_seq(1L);
        writeqna.setAnswer("answertest");
        service.insertQna(writeqna);
    }

}
