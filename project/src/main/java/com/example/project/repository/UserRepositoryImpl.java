package com.example.project.repository;

import com.example.project.dto.CreateUserDTO;
import com.example.project.entity.UserEntity;
import com.example.project.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private final UserMapper mapper;

    @Override
    public void join(UserEntity dto) {
        mapper.insertUser(dto);

    }
}
