package com.example.project.service;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.LoginSessionDTO;

public interface UserService {
    void join(CreateUserDTO user);
    LoginSessionDTO login(LoginUserDTO login);
}
