package com.example.project.mapper;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.LoginResultDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(CreateUserDTO member);
//    UserEntity findUser(UserEntity member);
    String loginUser(LoginUserDTO member);
    LoginResultDTO findById(String id);
    void deleteUser(Long user_seq);

}
