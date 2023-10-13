package com.example.project.dto.response.user;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Alias("ReviewPostReadDTO")
public class ReviewPostReadDTO {
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
}
