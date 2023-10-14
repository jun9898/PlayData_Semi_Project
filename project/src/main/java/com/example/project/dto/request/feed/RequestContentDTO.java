package com.example.project.dto.request.feed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestContentDTO {

    public String curPage;
    public String cutPage;
    public String searchType;
    public String keyword;
    public List<String> tag;

}
