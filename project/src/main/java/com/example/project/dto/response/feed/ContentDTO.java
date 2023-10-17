package com.example.project.dto.response.feed;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("ContentDTO")
@ToString
public class ContentDTO {

    private Long review_seq;
    private String title;
    private Long view_count;
    private Long star;
    private String img_1;
    private Timestamp created_at;
//    private UserDTO userDTO;
    // Username
    private String name;

}
