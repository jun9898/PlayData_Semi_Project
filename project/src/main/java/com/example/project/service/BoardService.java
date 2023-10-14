package com.example.project.service;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;

import java.util.List;

public interface BoardService {

    List<ContentDTO> getContentList(RequestContentDTO dto);
}
