package com.example.project.service;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    @Override
    public List<ContentDTO> getContentList(RequestContentDTO dto) {
        return repository.getContentList(dto);
    }
}
