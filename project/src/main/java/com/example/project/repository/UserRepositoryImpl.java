package com.example.project.repository;

import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.dto.response.LoginResultDTO;
import com.example.project.entity.UserEntity;
import com.example.project.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private final UserMapper mapper;

    @Override
    public void join(CreateUserDTO dto) {
        mapper.insertUser(dto);
    }

    @Override
    public UserEntity findById(String id) {
        return null;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }

    @Override
    public LoginResultDTO login(LoginUserDTO dto) {
        return mapper.loginUser(dto);
    }

}
