package com.example.project.dto.response.user;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("UserDTO")
public class LoginSessionDTO {

    private Long user_seq;
    private String email;
    private String id;
    private String name;
    private String sigungu_cd;


}