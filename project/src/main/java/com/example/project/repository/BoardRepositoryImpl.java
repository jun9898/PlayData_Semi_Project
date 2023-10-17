package com.example.project.repository;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{

    private final BoardMapper boardMapper;

    @Override
    public List<ContentDTO> getContentList(RequestContentDTO dto) {
//         return boardMapper.getContentList(dto);
        List<ContentDTO> contentList = boardMapper.getContentList(dto);
        for (ContentDTO content : contentList) {
            log.info(content.getTitle());
            log.info(content.getName());
        }
        return contentList;
    }
}
