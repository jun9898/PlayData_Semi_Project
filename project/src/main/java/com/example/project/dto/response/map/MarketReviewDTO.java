package com.example.project.dto.response.map;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketReviewDTO {
    String market_name;
    Long market_id;
    String address_name;
    String market_img;
    String writer_name;
    Integer review_count;
    Long market_seq;
    Double x;
    Double y;
    Integer distance;
    Double star_avg;

}
