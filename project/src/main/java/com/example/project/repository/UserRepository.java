package com.example.project.repository;

import com.example.project.dto.CreateUserDTO;
import com.example.project.entity.UserEntity;

public interface UserRepository {

    void join(UserEntity dto);
}
