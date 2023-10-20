package com.example.project.repository;

import com.example.project.dto.request.help.NoticeDTO;
import com.example.project.dto.request.help.QnaDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
import com.example.project.dto.response.help.NoticeReadDTO;
import com.example.project.dto.response.help.QnaReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;

import java.util.List;


public interface NoticeRepository {
    void write(NoticeDTO dto);
    NoticeReadDTO read(Long seq);
    List<NoticeReadDTO> readList();
    void update(NoticeDTO dto);
    void delete(Long seq);

    void writeqna(QnaDTO dto);
    QnaReadDTO readqna(Long qna_board_seq);
    List<QnaReadDTO> readqnaList();

}
