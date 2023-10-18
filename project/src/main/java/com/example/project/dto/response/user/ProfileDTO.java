package com.example.project.dto.response.user;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Alias("ProfileDTO")
@ToString
public class ProfileDTO {

    private Long user_seq;
    private String email;
    private String id;
    private String name;
    private String sigungu_cd;
    private Long post_count;
    private Long follower;
    private Long following;


}