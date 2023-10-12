package com.example.project.service;

import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.dto.response.LoginResultDTO;
import com.example.project.entity.UserEntity;
import com.example.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public void join(CreateUserDTO member) {
        repository.join(member);
    }

    @Override
    public LoginResultDTO login(LoginUserDTO login) {
        return repository.login(login);
    }
}
