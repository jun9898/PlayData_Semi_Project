package com.example.project.api;

import com.example.project.component.KakaoApi;
import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.map.ApiKeywordSearch;
import com.example.project.enums.PowerSwitch;
import com.example.project.enums.RankSearchType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



@SpringBootTest
public class ApiTest {

    private static final Logger log = LoggerFactory.getLogger(ApiTest.class);

    private KakaoApi api;

    @Autowired
    public ApiTest(KakaoApi api){
        this.api = api;
    }

    @Disabled
    @Test
    public void callKakaoMarketList(){
        try{
            SearchMapDTO dto = SearchMapDTO.builder()
                    .query("naver")
                    .latitude(37.514322572335935)
                    .longitude(127.06283102249932)
                    .radius(20000)
                    .build();
            ResponseEntity<?> list =  api.getMarketList(dto);

            ApiKeywordSearch api_dto = (ApiKeywordSearch) list.getBody();
            log.info("11" + (api_dto.meta.is_end() ? "true" : "false"));
            Boolean is_end_data = api_dto.meta.is_end();

            list.getStatusCode();
        }catch(HttpClientErrorException e){
            e.printStackTrace();
        }

    }


    @Disabled
    @Test
    public void Test(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String apiUrl = "https://dapi.kakao.com/v2/local/search/keyword.json?";
        String test_key = "491b696621bded5e3d563f1b56a7a472";
        headers.add("Authorization", "KakaoAK "+test_key);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                        .queryParam("x","127.141174")
                        .queryParam("y","35.813928")
                        .queryParam("radius",200000)
                        .queryParam("query","식당");
        HttpEntity req = new HttpEntity(headers);
        ResponseEntity<Object> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                req,
                Object.class
        );
        System.out.print(response);
    }

}

