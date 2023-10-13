package com.example.project.repository;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{

    private final BoardMapper boardMapper;

    @Override
    public List<ContentDTO> getContentList(RequestContentDTO dao) {
        return boardMapper.getContentList(dao);
    }
}
