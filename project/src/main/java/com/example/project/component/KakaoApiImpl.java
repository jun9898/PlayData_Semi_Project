package com.example.project.component;

import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.map.ApiKeywordSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class KakaoApiImpl implements KakaoApi{

    private RestTemplate restTemplate;

    @Value("${KAKAO_API_KEY}")
    private String API_KEY;

    @Value("${KAKAO_MAP_URL_PREFIX}")
    private String URL_PREFIX;

    private static final String SEARCH_CATEGORY_GROUP_CODE = "FD6";

    @Autowired
    public KakaoApiImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public ResponseEntity<ApiKeywordSearch> getMarketList(SearchMapDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + API_KEY);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(URL_PREFIX)
                .queryParam("category_group_code",SEARCH_CATEGORY_GROUP_CODE)
                .queryParam("x", dto.getLongitude())
                .queryParam("y", dto.getLatitude())
                .queryParam("radius", dto.getRadius())
                .queryParam("query", dto.getQuery());
        HttpEntity req = new HttpEntity(headers);
        ResponseEntity<ApiKeywordSearch> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                req,
                ApiKeywordSearch.class
        );

        return response;

    }


}

