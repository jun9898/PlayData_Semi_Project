package com.example.project.service;

import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.dto.response.write.BoardWriteDTO;
import com.example.project.dto.response.write.BoardWriteFileDTO;
import com.example.project.repository.BoardWriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BoardWriteServiceImpl implements BoardWriteService{
    private final BoardWriteRepository repository;



    @Override
    public void insert(BoardWriteDTO boardWriteDTO,String name,List<BoardWriteFileDTO> boardWriteFileDTOList) {
           BoardWriteDTO dto = repository.selectMarketSeq(name);
           System.out.println("insertdto serviceimpl = " + dto);
           if(dto != null){
               boardWriteDTO.setMarket_seq(dto.getMarket_seq());
           }
        System.out.println("insertdto serviceimpl=========================== " + boardWriteDTO);
             repository.insert(boardWriteDTO);
        System.out.println("boardWriteFileDTOList = " +boardWriteFileDTOList );
             repository.insertFile(boardWriteFileDTOList);




    }
    @Override
    public BoardWriteDTO selectMarketSeq(String name) {
        BoardWriteDTO dto = repository.selectMarketSeq(name);
        System.out.println("marketseqServiceImpl dto ================================= " + dto);
        return dto;
    }

    @Override
    public int update(BoardWriteDTO board) {
        return repository.update(board);
    }

    @Override
    public int delete(Long review_seq) {
        return repository.delete(review_seq);
    }

    @Override
    public List<BoardWriteFileDTO> getFileList(Long review_seq) {
        return repository.getFileList(review_seq);
    }

    @Override
    public BoardWriteFileDTO getFile(BoardWriteFileDTO inputdata) {
        return repository.getFile(inputdata);
    }
}
