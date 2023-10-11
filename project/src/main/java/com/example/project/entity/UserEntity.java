package com.example.project.entity;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
public class UserEntity {

    private Long user_seq;
    private String email;
    private String id;
    private String phone_num;
    private Long user_type_cd;
    private String name;
    private String password;
    private String sigungu_cd;
    private String email_agree_yn;
    private String email_agree_at;
    private String last_login_at;
    private String created_at;
    private String updated_at;
    private String deleted_at;

    @Builder
    public UserEntity(String email, String id, String phone_num, String name, String password, String sigungu_cd, Long user_type_cd) {
        this.email = email;
        this.id = id;
        this.phone_num = phone_num;
        this.name = name;
        this.password = password;
        this.sigungu_cd = sigungu_cd;
        this.user_type_cd = user_type_cd;
    }
}