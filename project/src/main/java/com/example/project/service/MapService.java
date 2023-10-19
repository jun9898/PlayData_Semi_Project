package com.example.project.service;

import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.map.AreaReviewCountDTO;
import com.example.project.dto.response.map.MarketReviewDTO;

import java.util.List;

public interface MapService {
    public List<MarketReviewDTO> getMarketList(SearchMapDTO dto);
    public List<AreaReviewCountDTO> getAreaCount(SearchMapDTO dto);
}
