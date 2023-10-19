package com.example.project.dto.request.map;


import com.example.project.dto.TagDto;
import com.example.project.enums.MapSearhContentRange;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class SearchMapDTO {

    private String query;
    private Double latitude;    // Y(중심좌표 기준 위도)
    private Double longitude;   // X(중심좌표 경도)
    private Integer radius;
    private Integer level;
    private String rect;   // 영역
    private MapSearhContentRange searchType; // 검색 타입
    private List<TagDto> tags;


}
