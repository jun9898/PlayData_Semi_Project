package com.example.project.repository;

import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.dto.request.UserDTO;
import com.example.project.entity.UserEntity;

public interface UserRepository {

    void join(CreateUserDTO dto);
    UserDTO findById(String id);
    UserEntity findByEmail(String email);
    String login(LoginUserDTO dto);
}
