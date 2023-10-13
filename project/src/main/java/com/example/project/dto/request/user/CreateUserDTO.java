package com.example.project.dto.request.user;

import com.example.project.entity.UserEntity;
import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("CreateUserDTO")
public class CreateUserDTO {

    private String email;
    private String id;
    private String phone_num;
    private String name;
    private String password;
    private String sigungu_cd;

//    JPA 사용시 사용될 factory method 패턴
//    public UserEntity toCreateUserEntity(){
//        return UserEntity.builder()
//                .name(name)
//                .id(id)
//                .email(email)
//                .password(password)
//                .phone_num(phone_num)
//                .sigungu_cd(sigungu_cd)
//                .build();
//    }
}
