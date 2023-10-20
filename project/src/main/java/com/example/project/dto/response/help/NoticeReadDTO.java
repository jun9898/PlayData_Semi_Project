package com.example.project.dto.response.help;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("NoticeReadDTO")
public class NoticeReadDTO {
    private String title;
    private String content;
    private Long view_count;
    private String created_at;
    private Long seq;
}
