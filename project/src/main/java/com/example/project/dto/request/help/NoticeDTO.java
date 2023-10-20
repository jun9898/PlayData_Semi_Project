package com.example.project.dto.request.help;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("NoticeDTO")
public class NoticeDTO {
    private String title;
    private String content;
    private Long view_count;
    private Long create_admin_seq;
}
