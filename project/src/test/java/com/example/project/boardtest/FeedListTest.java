package com.example.project.boardtest;

import com.example.project.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class FeedListTest {

    @Autowired
    BoardService service;

    @Test
    @Rollback
    public void contentListTest() {

/*
        RequestContentDTO dto = new RequestContentDTO(1L,20L,"","",null);
        List<ContentDTO> contentList = service.getContentList(dto);
        for (ContentDTO content : contentList) {
            System.out.println(content.getTitle());
            System.out.println(content.getReview_seq());
            System.out.println(content.getName());

        }
*/

    }
}
