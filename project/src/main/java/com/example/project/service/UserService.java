package com.example.project.service;

import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;

public interface UserService {
    void join(CreateUserDTO user);
    String login(LoginUserDTO login);
}
