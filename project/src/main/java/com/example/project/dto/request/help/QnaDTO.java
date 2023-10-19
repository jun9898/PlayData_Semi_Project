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
@Alias("QnaDTO")
public class QnaDTO {
    private String title;
    private String content;
    private Long user_seq;
    private String answer;

}
