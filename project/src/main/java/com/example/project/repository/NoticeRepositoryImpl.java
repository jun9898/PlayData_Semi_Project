package com.example.project.repository;

import com.example.project.dto.request.help.NoticeDTO;
import com.example.project.dto.request.help.QnaDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
import com.example.project.dto.response.help.NoticeReadDTO;
import com.example.project.dto.response.help.QnaReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.mapper.NoticeMapper;
import com.example.project.mapper.ReviewPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeRepositoryImpl implements NoticeRepository{
    private final NoticeMapper mapper;

    @Override
    public void write(NoticeDTO dto){
        mapper.insertNotice(dto);
    }
    @Override
    public NoticeReadDTO read(Long seq){
       return mapper.getNotice(seq);
    }

    @Override
    public List<NoticeReadDTO> readList(){
        return mapper.getNoticeList();
    }


    @Override
    public void update(NoticeDTO dto) {
    }
    @Override
    public void delete(Long seq) {
        mapper.deleteNotice(seq);
    }

    @Override
    public void writeqna(QnaDTO dto){
        mapper.insertQna(dto);
    }
    @Override
    public QnaReadDTO readqna(Long qna_board_seq){
        return mapper.getQna(qna_board_seq);
    }

    @Override
    public List<QnaReadDTO> readqnaList(){
        return mapper.getQnaList();
    }


}
