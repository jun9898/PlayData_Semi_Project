package com.example.project.dto.request.review;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("ReviewCommentRecommandDTO")
public class ReviewCommentRecommandDTO {
    private Long comment_seq;
    private Long user_seq;
}
