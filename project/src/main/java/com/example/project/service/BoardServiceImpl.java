package com.example.project.service;

import com.example.project.component.KakaoApi;
import com.example.project.dto.TagDto;
import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.map.ApiKeywordSearchDTO;
import com.example.project.dto.response.map.MarketReviewDTO;
import com.example.project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;
    private final KakaoApi kakao_api;

    @Override
    public List<ContentDTO> getContentList(RequestContentDTO dto) {
        return repository.getContentList(dto);
    }

    @Override
    public List<MarketReviewDTO> getMarketAndReviewList(SearchMapDTO dto) {
        if (dto != null) {
            try {
                ApiKeywordSearchDTO api_dto = (ApiKeywordSearchDTO) kakao_api.getMarketList(dto).getBody();
                if (api_dto != null && api_dto.meta.getTotal_count() != 0)
                    log.info("api update data count = " + repository.upsertMarketList(api_dto.getDocumentsList()));
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
