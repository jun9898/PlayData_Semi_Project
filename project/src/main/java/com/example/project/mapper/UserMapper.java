package com.example.project.mapper;

import com.example.project.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insertUser(UserEntity member);

}
