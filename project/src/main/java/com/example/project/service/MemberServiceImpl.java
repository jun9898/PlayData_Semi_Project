package com.example.project.service;

import com.example.project.dto.UserDTO;
import com.example.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void join(UserDTO member) {

    }

    @Override
    public UserDTO findMember(Long memberId) {
        return null;
    }
}
