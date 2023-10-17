package com.example.project.dto.request.review;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("ReviewCommentDTO")
public class ReviewCommentDTO {
    private Long review_seq;
    private Long comment_seq;
    private Long user_seq;
    private String content;


}
