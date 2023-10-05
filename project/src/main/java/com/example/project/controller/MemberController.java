package com.example.project.controller;

import com.example.project.dto.UserDTO;
import com.example.project.service.MemberService;
import lombok.RequiredArgsConstructor;

//@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    public void join(UserDTO member) {
        memberService.join(member);
    }

    public UserDTO findMember(Long memberId) {
        return memberService.findMember(memberId);
    }


}
