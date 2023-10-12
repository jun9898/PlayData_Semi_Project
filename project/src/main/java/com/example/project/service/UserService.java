package com.example.project.service;

import com.example.project.dto.user.CreateUserDTO;

public interface UserService {
    void join(CreateUserDTO user);
    CreateUserDTO findMember(Long memberId);
}
