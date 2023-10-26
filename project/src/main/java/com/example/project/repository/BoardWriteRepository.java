package com.example.project.repository;

import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.dto.response.write.BoardWriteDTO;
import com.example.project.dto.response.write.BoardWriteFileDTO;

import java.util.List;

public interface BoardWriteRepository {
    void insert(BoardWriteDTO boardWriteDTO);

    BoardWriteDTO selectMarketSeq(String name);
    int update(BoardWriteDTO board);
    int delete(Long review_seq);
    List<BoardWriteFileDTO> getFileList(Long review_seq);
    BoardWriteFileDTO getFile(BoardWriteFileDTO inputdata);
    int insertFile(List<BoardWriteFileDTO> boardWriteFileDTOList);
}
