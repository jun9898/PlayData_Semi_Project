package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String email;
    private String id;
    private String phone_num;
    private int user_type_cd;
    private String name;
    private String password;
    private String sigungu_cd;
    private String email_agree_yn;
    private String email_agree_at;
    private String last_login_at;
    private String create_at;
    private String updated_at;
    private String deleted_at;


}
