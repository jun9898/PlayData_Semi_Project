package com.example.project.dto.request.feed;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestContentDTO {

    public Long user_seq;
    public Long curPage;
    public Long cutPage;
    public String searchType;
    public String keyword;
    // tag는 DTO로 묶어서 사용할것
    public List<String> tag;

}
