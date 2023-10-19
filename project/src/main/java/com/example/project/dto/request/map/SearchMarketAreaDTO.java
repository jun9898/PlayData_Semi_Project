package com.example.project.dto.request.map;

import com.example.project.dto.TagDto;

import java.util.List;

public class SearchMarketAreaDTO {
    private String query;
    private Double latitude;    // Y(중심좌표 기준 위도)
    private Double longitude;   // X(중심좌표 경도)
    private Integer level;
    private List<TagDto> tags;

}
