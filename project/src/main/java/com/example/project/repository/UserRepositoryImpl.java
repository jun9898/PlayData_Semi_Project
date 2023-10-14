package com.example.project.repository;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.LoginResultDTO;
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
    public LoginResultDTO findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }

    @Override
    public String login(LoginUserDTO dto) {
        return mapper.loginUser(dto);
    }

}
