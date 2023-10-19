package com.example.project.component;


import com.example.project.dto.request.map.SearchMapDTO;
import org.springframework.http.ResponseEntity;

public interface KakaoApi {
    public ResponseEntity<?> getKewordMarketList(SearchMapDTO dto);
    public ResponseEntity<?> getCategoryMarketList(SearchMapDTO dto);
}

