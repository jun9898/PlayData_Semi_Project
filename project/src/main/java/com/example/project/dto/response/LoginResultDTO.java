package com.example.project.dto.response;

import com.example.project.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("LoginResultDTO")
public class LoginResultDTO {

    private String id;
    private String password;

}
