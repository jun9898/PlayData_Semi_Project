package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {

    private String email;
    private String id;
    private String phone_num;
    private String user_type_cd;
    private String name;
    private String password;
    private String sigungu_cd;
    private String email_agree_yn;

}
