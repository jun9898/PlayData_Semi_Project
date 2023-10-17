package com.example.project.component;


import com.example.project.dto.request.map.SearchMapDTO;
import org.springframework.http.ResponseEntity;

public interface KakaoApi {
    public ResponseEntity<?> getMarketList(SearchMapDTO dto);

}

