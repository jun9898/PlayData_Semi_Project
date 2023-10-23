package com.example.project.dto.request;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Alias("ReviewViewDTO")
public class ReviewViewDTO {
    private Long market_seq;
    private Long review_seq;
    private String name;
    private String img_url;
    private String title;
    private int star;
    private String created_at;
}
