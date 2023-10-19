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
@Alias("QnaReadDTO")
public class QnaReadDTO {
    private String title;
    private String content;
    private Long view_count;
    private Long user_seq;
    private String answer_at;
    private String answer;
    private Long qna_board_seq;
}
