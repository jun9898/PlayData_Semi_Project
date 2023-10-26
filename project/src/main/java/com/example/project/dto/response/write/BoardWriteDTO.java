package com.example.project.dto.response.write;

import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("BoardWriteDTO")
public class BoardWriteDTO {
    private Long review_seq;
    private Long user_seq;
    private Long market_seq;
    private String title;
    private String name;
    private String content;
    private Long star;
    private String img_1;
    private String img_2;
    private String img_3;
    private String img_4;
    private String img_5;
    private String created_at;
    private String recommend_count;
    private List<MultipartFile> files;
}

