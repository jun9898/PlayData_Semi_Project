package com.example.project.dto.response.user;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("LoginResultDTO")
public class LoginResultDTO {

    private Long user_seq;
    private String email;
    private String id;
    private String name;
    private String sigungu_cd;
    private String password;

    public LoginSessionDTO toCreateLoginSessionDTO(){
        return LoginSessionDTO.builder()
                .user_seq(user_seq)
                .name(name)
                .id(id)
                .email(email)
                .sigungu_cd(sigungu_cd)
                .build();
    }

}