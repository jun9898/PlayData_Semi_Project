package com.example.project.service;

import com.example.project.dto.CreateUserDTO;
import com.example.project.entity.UserEntity;
import com.example.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public void join(UserEntity member) {
        UserEntity user = UserEntity.builder()
                .id(member.getId())
                .sigungu_cd(member.getSigungu_cd())
                .phone_num(member.getPhone_num())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .user_type_cd(member.getUser_type_cd())
                .build();
        repository.join(user);
    }

    @Override
    public CreateUserDTO findMember(Long memberId) {
        return null;
    }
}
