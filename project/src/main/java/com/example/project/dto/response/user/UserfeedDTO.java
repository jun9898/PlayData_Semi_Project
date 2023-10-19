package com.example.project.dto.response.user;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Alias("UserfeedDTO")
@ToString
public class UserfeedDTO {

    private Long id;
    private Long review_seq;
    private Long comment_cnt;
    private Long recommend_cnt;
    private String img_1;


}