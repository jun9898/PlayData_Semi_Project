package com.example.project.mapper;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.request.help.NoticeDTO;
import com.example.project.dto.request.help.QnaDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.help.NoticeReadDTO;
import com.example.project.dto.response.help.QnaReadDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    void insertNotice(NoticeDTO noticeDTO);
    NoticeReadDTO getNotice(Long seq);
    List<NoticeReadDTO> getNoticeList();
    void updateNotice(NoticeDTO noticeDTO);
    void deleteNotice(Long seq);

    void insertQna(QnaDTO qnaDTO);
    QnaReadDTO getQna(Long seq);
    List<QnaReadDTO> getQnaList();

}
