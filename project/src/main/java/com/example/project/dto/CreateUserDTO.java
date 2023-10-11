package com.example.project.dto;

import com.example.project.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    private String email;
    private String id;
    private String phone_num;
    private String name; //닉네임
    private String password;
    private String sigungu_cd;

}
