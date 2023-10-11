package com.example.project.service;

import com.example.project.dto.CreateUserDTO;
import com.example.project.entity.UserEntity;

public interface UserService {
    void join(UserEntity user);
    CreateUserDTO findMember(Long memberId);
}
