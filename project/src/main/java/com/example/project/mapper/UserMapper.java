package com.example.project.mapper;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.FollowDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.FollowlistDTO;
import com.example.project.dto.response.user.LoginResultDTO;
import com.example.project.dto.response.user.ProfileDTO;
import com.example.project.dto.response.user.UserfeedDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    void insertUser(CreateUserDTO member);
//    UserEntity findUser(UserEntity member);
    String loginUser(LoginUserDTO member);
    LoginResultDTO findById(String id);
    void deleteUser(Long user_seq);
    int findFollow(FollowDTO dto);
    void insertFollow(FollowDTO dto);
    void deleteFollow(FollowDTO dto);
    ProfileDTO findProfile(String id);
    List<UserfeedDTO> myfeedlist(String id);

    List<FollowlistDTO> followinglist(Long follower_user_seq);//팔로우로 표시될 것
    List<FollowlistDTO> followerlist(Long following_user_seq);//팔로잉으로 표시 것
}
