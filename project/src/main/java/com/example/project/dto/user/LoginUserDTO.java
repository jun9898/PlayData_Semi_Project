package com.example.project.dto.user;

import com.example.project.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDTO {

    private String id;
    private String password;

    public UserEntity toCreateUserEntity(){
        return UserEntity.builder()
                .id(id)
                .password(password)
                .build();
    }

}
