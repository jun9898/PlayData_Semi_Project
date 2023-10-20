package com.example.project.service;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.FollowDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.FollowlistDTO;
import com.example.project.dto.response.user.ProfileDTO;
import com.example.project.dto.response.user.UserDTO;
import com.example.project.dto.response.user.UserfeedDTO;

import java.util.List;

public interface UserService {
    void join(CreateUserDTO user);
    UserDTO login(LoginUserDTO login);
    void deleteUser(Long user_seq);
    UserDTO findById(String id);
    int findFollow(FollowDTO dto);
    void following(FollowDTO dto);
    void unFollowing(FollowDTO dto);
    ProfileDTO findProfile(String id);
    List<UserfeedDTO> myfeedlist(String id);
    List<FollowlistDTO> readfollowingList(Long follower_user_seq);
    List<FollowlistDTO> readfollowerList(Long following_user_seq);
}
