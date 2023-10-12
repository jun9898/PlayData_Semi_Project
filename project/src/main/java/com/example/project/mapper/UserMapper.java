package com.example.project.mapper;

import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.dto.response.LoginResultDTO;
import com.example.project.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(CreateUserDTO member);
//    UserEntity findUser(UserEntity member);
    LoginResultDTO loginUser(LoginUserDTO member);

}
