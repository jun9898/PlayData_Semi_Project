package com.example.project.service;

import com.example.project.dto.user.CreateUserDTO;
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
        UserEntity user = member.toCreateUserEntity();
        repository.join(user);
    }

    @Override
    public CreateUserDTO findMember(Long memberId) {
        return null;
    }
}
