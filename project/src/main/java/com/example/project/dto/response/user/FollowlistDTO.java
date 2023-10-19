package com.example.project.dto.response.user;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Alias("FollowlistDTO")
@ToString
public class FollowlistDTO {
    private Long following_user_seq;
    private Long follower_user_seq;
    private Long user_seq;
    private String email;
    private String id;
    private String name;
}