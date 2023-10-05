package com.example.project.repository;

import com.example.project.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<String, UserDTO> store = new HashMap<>();

    @Override
    public void save(UserDTO member) {
        store.put(member.getId(), member);
    }

    @Override
    public UserDTO findById(Long memberId) {
        return store.get(memberId);
    }
}
