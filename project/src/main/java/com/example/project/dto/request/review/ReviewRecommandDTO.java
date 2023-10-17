package com.example.project.dto.request.review;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("ReviewRecommandDTO")
public class ReviewRecommandDTO {
    private Long review_seq;
    private Long user_seq;
}
