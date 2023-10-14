package com.example.project.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("LoginUserDTO")
public class LoginUserDTO {

    private String id;
    private String password;
//    private String password;
//    private String password;
//    private String password;


//    JPA 사용시 사용될 factory method 패턴
//    public UserEntity toCreateUserEntity(){
//        return UserEntity.builder()
//                .id(id)
//                .password(password)
//                .build();
//    }

}
