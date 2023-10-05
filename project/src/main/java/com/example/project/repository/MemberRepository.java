package com.example.project.repository;

import com.example.project.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
    void save(UserDTO member);
    UserDTO findById(Long memberId);
}
