package com.example.project.service;

import com.example.project.dto.request.help.NoticeDTO;
import com.example.project.dto.request.help.QnaDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
import com.example.project.dto.response.help.NoticeReadDTO;
import com.example.project.dto.response.help.QnaReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.dto.response.user.UserfeedDTO;

import java.util.List;


public interface NoticeService {

    void insertNotice(NoticeDTO noticeDTO);
    NoticeReadDTO getNotice(Long seq);
    List<NoticeReadDTO> getNoticeList();
    void updateNotice(NoticeDTO noticeDTO);
    void deleteNotice(Long seq);
    void insertQna(QnaDTO qnaDTO);
    QnaReadDTO getQna(Long seq);
    List<QnaReadDTO> getQnaList();
}