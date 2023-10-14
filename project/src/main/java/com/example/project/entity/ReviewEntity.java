package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

//@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ReviewEntity {
    private Long review_seq;
    private Long user_seq;
    private String title;
    private String content;
    private Long view_count;
    private Long star;
    private String img_1;
    private String img_2;
    private String img_3;
    private String img_4;
    private String img_5;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;

//    public ReviewEntity(String title, String content, Long view_count, Long star, String img_1, String img_2, String img_3, String img_4, String img_5, Timestamp created_at) {
//        this.title = title;
//        this.content = content;
//        this.view_count = view_count;
//        this.star = star;
//        this.img_1 = img_1;
//        this.img_2 = img_2;
//        this.img_3 = img_3;
//        this.img_4 = img_4;
//        this.img_5 = img_5;
//        this.created_at = created_at;
//    }
}
