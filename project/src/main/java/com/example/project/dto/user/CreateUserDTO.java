package com.example.project.dto.user;

import com.example.project.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    private String email;
    private String id;
    private String phone_num;
    private String name;
    private String password;
    private String sigungu_cd;

    public UserEntity toCreateUserEntity(){
        return UserEntity.builder()
                .name(name)
                .id(id)
                .email(email)
                .password(password)
                .phone_num(phone_num)
                .sigungu_cd(sigungu_cd)
                .build();
    }
}
