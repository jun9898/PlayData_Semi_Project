package com.example.project.dto.response.review;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Alias("ReviewCommentReadDTO")
public class ReviewCommentReadDTO {
    private Long comment_seq;
    private Long review_seq;
    private Long user_seq;
    private String content;
    private String name;
    private String created_at;
    private String recommend_count;
}
