package com.example.project.service;

import com.example.project.component.KakaoApi;
import com.example.project.dto.TagDto;
import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.map.ApiSearchDTO;
import com.example.project.dto.response.map.MarketReviewDTO;
import com.example.project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;
    private final KakaoApi kakao_api;

    @Override
    public List<ContentDTO> getContentList(RequestContentDTO dto) {
        if (dto.getSearchtype().equals("following")){
            return repository.getFollowContentList(dto);
        } else {
            return repository.getContentList(dto);
        }
    }


    @Transactional
    @Override
    public List<MarketReviewDTO> getMarketAndReviewList(SearchMapDTO dto) {
        if (dto != null) {
            try {
                ApiSearchDTO api_dto;
                if (dto.getQuery() != null && !dto.getQuery().isBlank()){
                    api_dto = (ApiSearchDTO) kakao_api.getKewordMarketList(dto).getBody();
                }else{
                    api_dto = (ApiSearchDTO) kakao_api.getCategoryMarketList(dto).getBody();
                }
                if (api_dto != null && api_dto.meta.getTotal_count() != 0) {
                    repository.upsertMarketList(api_dto.getDocuments());
                }
            } catch (IllegalArgumentException e) {
                log.error(e.getMessage());
            }
        }
        return repository.getMarketAndReviewList(dto);
    }

    @Override
    public List<TagDto> getTagList() {
        return repository.getTagList();
    }


}
