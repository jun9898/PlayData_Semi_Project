package com.example.project.dto.response.rank;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("ReviewRankDTO")
public class ReviewRankDTO {
    private Long user_seq;
    private String img_url;
    private String name;
    private String email;
    private Long review_seq;
    private Long review_count;
    private Long recommand_count;
    private Timestamp createde_at;
}
