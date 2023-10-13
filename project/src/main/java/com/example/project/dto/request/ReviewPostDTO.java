package com.example.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("ReviewPostDTO")
public class ReviewPostDTO {
    private Long review_seq;
    private Long user_seq;
    private Long market_seq;
    private String title;
    private String content;
    private Long view_count;
    private Long star;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String img5;
    private String created_at;
    private String updated_at;
    private String deleted_at;

}
