package com.example.project.repository;

import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.dto.response.write.BoardWriteDTO;
import com.example.project.dto.response.write.BoardWriteFileDTO;
import com.example.project.mapper.BoardMapper;
import com.example.project.mapper.MarketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class BoardWriteRepositoryImpl implements BoardWriteRepository{
    private final BoardMapper mapper;
    private final MarketMapper marketMapper;
    @Override
    public void insert(BoardWriteDTO boardWriteDTO) {
        mapper.insertBoardWrite(boardWriteDTO);

    }

    @Override
    public BoardWriteDTO selectMarketSeq(String name) {
        BoardWriteDTO dto = mapper.selectMarketSeq(name);
        System.out.println("marketseqRepoImple dto ====================================== " + dto);
        return dto;
    }

    @Override
    public int update(BoardWriteDTO board) {
        return mapper.updateBoardWrite(board);

    }

    @Override
    public int delete(Long review_seq) {
        return mapper.deleteBoardWrite(review_seq);
    }

    @Override
    public List<BoardWriteFileDTO> getFileList(Long review_seq) {
        return null;
    }

    @Override
    public BoardWriteFileDTO getFile(BoardWriteFileDTO inputdata) {
        return null;
    }

    @Override
    public int insertFile(List<BoardWriteFileDTO> boardWriteFileDTOList) {

        return mapper.fileinsert(boardWriteFileDTOList);
    }
}
