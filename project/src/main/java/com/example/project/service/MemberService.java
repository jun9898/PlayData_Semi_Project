package com.example.project.service;

import com.example.project.dto.UserDTO;

public interface MemberService {
    void join(UserDTO member);
    UserDTO findMember(Long memberId);
}
