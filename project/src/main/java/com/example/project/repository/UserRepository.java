package com.example.project.repository;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.LoginResultDTO;
import com.example.project.dto.response.user.UserDTO;

public interface UserRepository {

    void join(CreateUserDTO dto);
    LoginResultDTO findById(String id);
    UserDTO findByEmail(String email);
    String login(LoginUserDTO dto);
    void deleteUser(Long user_seq);
}
