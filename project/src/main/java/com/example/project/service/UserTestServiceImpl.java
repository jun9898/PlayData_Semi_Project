package com.example.project.service;

import com.example.project.dto.MemberTestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTestServiceImpl implements UserTestService{

    static List<MemberTestDTO> follower = new ArrayList<>();
    static List<MemberTestDTO> following = new ArrayList<>();

    static {
        MemberTestDTO member1 = new MemberTestDTO("전병준","jun@gmail.com");
        MemberTestDTO member2 = new MemberTestDTO("전병준1","jun@gmail.com");
        MemberTestDTO member3 = new MemberTestDTO("전병준2","jun@gmail.com");
        MemberTestDTO member4 = new MemberTestDTO("전병준3","jun@gmail.com");
        MemberTestDTO member5 = new MemberTestDTO("전병준4","jun@gmail.com");
        MemberTestDTO member6 = new MemberTestDTO("전병준5","jun@gmail.com");
        follower.add(member1);
        follower.add(member2);
        follower.add(member3);
        follower.add(member1);
        follower.add(member2);
        follower.add(member3);
        following.add(member4);
        following.add(member5);
        following.add(member6);
        following.add(member4);
        following.add(member5);
        following.add(member6);
    }

    @Override
    public List<MemberTestDTO> testLogic(String status) {
        if (status.equals("follower")){
            return follower ;
        } else {
            return following ;
        }
    }
}
