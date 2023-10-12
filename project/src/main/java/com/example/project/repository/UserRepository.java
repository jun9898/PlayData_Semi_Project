package com.example.project.repository;

import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.dto.response.LoginResultDTO;
import com.example.project.entity.UserEntity;

public interface UserRepository {

    void join(CreateUserDTO dto);
    UserEntity findById(String id);
    UserEntity findByEmail(String email);
    LoginResultDTO login(LoginUserDTO dto);
}
