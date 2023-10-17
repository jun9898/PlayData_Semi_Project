package com.example.project.service;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.FollowDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.UserDTO;

public interface UserService {
    void join(CreateUserDTO user);
    UserDTO login(LoginUserDTO login);
    void deleteUser(Long user_seq);
    UserDTO findById(String id);
    int findFollow(FollowDTO dto);
    void following(FollowDTO dto);
    void unFollowing(FollowDTO dto);

}
