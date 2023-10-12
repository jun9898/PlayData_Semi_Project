package com.example.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("UserDTO")
public class UserDTO {

    private Long user_seq;
    private String email;
    private String id;
    private String phone_num;
    private String name;
    private String password;
    private String sigungu_cd;
    private String email_agree_yn;
    private String email_agree_at;
    private String last_login_at;
    private String created_at;
    private String updated_at;
    private String deleted_at;

}