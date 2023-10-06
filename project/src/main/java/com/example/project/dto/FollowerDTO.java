package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowerDTO {

    private Long seq;
    private String follower_user_seq;
    private String following_user_seq;
    private String created_at;
}
