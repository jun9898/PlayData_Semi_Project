package com.example.project.dto.request.map;


import com.example.project.dto.TagDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class SearchMapDTO {

    private String query;
    private Double latitude;    // Y(위도)
    private Double longitude;   // X(경도)
    private String searchType;
    private Integer radius;
    private Double centerLa;    //
    private Double centerMa;

    private List<TagDto> tags;





}
