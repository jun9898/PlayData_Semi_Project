package com.example.project.service;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.UserDTO;

public interface UserService {
    void join(CreateUserDTO user);
    UserDTO login(LoginUserDTO login);
}
