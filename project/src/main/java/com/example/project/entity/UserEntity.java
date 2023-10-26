package com.example.project.entity;

import lombok.*;
//@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

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

//    JPA 사용시 사용할 Builder 패턴
//    public UserEntity(String email, String id, String phone_num, String name, String password, String sigungu_cd) {
//        this.email = email;
//        this.id = id;
//        this.phone_num = phone_num;
//        this.name = name;
//        this.password = password;
//        this.sigungu_cd = sigungu_cd;
//    }
//
//    public UserEntity(String id, String password) {
//        this.id = id;
//        this.password = password;
//    }
}