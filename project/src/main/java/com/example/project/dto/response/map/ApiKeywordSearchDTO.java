package com.example.project.dto.response.map;


import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ApiKeywordSearchDTO {


    public List<MarketDocumentDTO> documentsList;
    public Meta meta;

    @Getter
    public static class Meta {
        private Integer total_count; //	검색어에 검색된 문서 수
        private Integer pageable_count; //	total_count 중 노출 가능 문서 수 (최대: 45)
        private Boolean is_end; //	현재 페이지가 마지막 페이지인지 여부
        public SameName same_name; //	질의어의 지역 및 키워드 분석 정보

        @Getter
        public static class SameName {
            String[] region;
            String keyword;
            String selected_region;
        }
    }





}
