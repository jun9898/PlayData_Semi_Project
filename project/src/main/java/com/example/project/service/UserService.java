package com.example.project.service;

import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.dto.response.LoginResultDTO;
import com.example.project.entity.UserEntity;

public interface UserService {
    void join(CreateUserDTO user);
    LoginResultDTO login(LoginUserDTO login);
}
