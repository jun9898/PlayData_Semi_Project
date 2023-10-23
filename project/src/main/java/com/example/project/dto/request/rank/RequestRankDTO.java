package com.example.project.dto.request.rank;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestRankDTO {
    public Long use_seq;
    public Long curPage;
    public Long cutPage;
    public String searchType;
    public String keyword;

}
