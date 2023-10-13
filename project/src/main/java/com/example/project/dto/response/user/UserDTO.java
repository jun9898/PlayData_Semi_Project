package com.example.project.dto.response.user;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Alias("UserDTO")
public class UserDTO {

    private Long user_seq;
    private String email;
    private String id;
    private String name;
    private String sigungu_cd;


}