package com.example.project.repository;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.FollowDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.help.NoticeReadDTO;
import com.example.project.dto.response.user.*;

import java.util.List;

public interface UserRepository {

    void join(CreateUserDTO dto);
    LoginResultDTO findById(String id);
    UserDTO findByEmail(String email);
    String login(LoginUserDTO dto);
    void deleteUser(Long user_seq);
    int findFollow(FollowDTO dto);
    void insertFollow(FollowDTO dto);
    void deleteFollow(FollowDTO dto);
    ProfileDTO findProfile(String id);
    List<UserfeedDTO> feedList(String id);
    List<FollowlistDTO> readfollowingList(Long follower_user_seq);//팔로우로 표시될 것
    List<FollowlistDTO> readfollowerList(Long following_user_seq);//팔로잉으로 표시 것

}
