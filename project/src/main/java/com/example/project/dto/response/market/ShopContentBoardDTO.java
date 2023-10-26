package com.example.project.dto.response.market;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("ShopContentBoardDTO")
public class ShopContentBoardDTO {
    private Long market_seq;
    private Long market_id;
    private String name;
    private Double x;
    private Double y;
    private Long category_cd;
    private String phone_num;

    private String image_url;
    private String address_name;
    private String road_address_name;

    private String place_url;
    private String sigungu_cd;
}
