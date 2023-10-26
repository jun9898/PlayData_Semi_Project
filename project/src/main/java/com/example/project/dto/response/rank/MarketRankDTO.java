package com.example.project.dto.response.rank;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("MarketRankDTO")
public class MarketRankDTO {
   private Long user_seq;
   private Long market_seq;
   private String name;
   private String image_url;
   private Long review_count;
   private String star_count;
   private Timestamp created_at;


}
