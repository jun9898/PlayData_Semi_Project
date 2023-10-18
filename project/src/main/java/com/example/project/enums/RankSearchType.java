package com.example.project.enums;

import lombok.Getter;

@Getter
public enum RankSearchType {
    MARKET("가게","market"), REVIEW("리뷰","review");
    private String kr_name;
    private String eng_name;
    RankSearchType(String kr_name,String eng_name){
        this.kr_name = kr_name;
        this.eng_name = eng_name;
    }
}
