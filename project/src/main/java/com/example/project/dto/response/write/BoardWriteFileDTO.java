package com.example.project.dto.response.write;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("BoardWriteFileDTO")
public class BoardWriteFileDTO {
    private Long review_seq;
    private String originalFilename;
    private String storeFilename;
    private String boardFileorder;

    public BoardWriteFileDTO(String originalFilename, String storeFilename) {
        this.originalFilename = originalFilename;
        this.storeFilename = storeFilename;
    }

    public BoardWriteFileDTO(String originalFilename, String storeFilename, String boardFileorder) {
        this.originalFilename = originalFilename;
        this.storeFilename = storeFilename;
        this.boardFileorder = boardFileorder;
    }
}
