package com.example.project.repository;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;

import java.util.List;

public interface BoardRepository {

    List<ContentDTO> getContentList(RequestContentDTO dao);

}
