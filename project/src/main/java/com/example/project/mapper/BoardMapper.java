package com.example.project.mapper;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<ContentDTO> getContentList(RequestContentDTO dto);

}
