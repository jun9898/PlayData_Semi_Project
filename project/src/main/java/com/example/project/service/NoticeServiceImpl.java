package com.example.project.service;

import com.example.project.dto.request.help.NoticeDTO;
import com.example.project.dto.request.help.QnaDTO;
import com.example.project.dto.request.review.ReviewPostDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
import com.example.project.dto.response.help.NoticeReadDTO;
import com.example.project.dto.response.help.QnaReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.repository.NoticeRepository;
import com.example.project.repository.ReviewPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository repository;

    @Override
    public void insertNotice(NoticeDTO noticeDTO) {
        repository.write(noticeDTO);
    }

    @Override
    public NoticeReadDTO getNotice(Long seq) {
        return repository.read(seq);
    }

    @Override
    public List<NoticeReadDTO> getNoticeList() {
        return repository.readList();
    }

    @Override
    public void updateNotice(NoticeDTO noticeDTO) {

    }
    @Override
    public void deleteNotice(Long seq) {
        NoticeReadDTO existingPost = repository.read(seq);
        if (existingPost != null) {
            repository.delete(seq);
        } else {

            System.out.println("삭제할 게시물이 존재하지 않습니다.");
        }
    }

    @Override
    public void insertQna(QnaDTO qnaDTO) {
        repository.writeqna(qnaDTO);
    }

    @Override
    public QnaReadDTO getQna(Long qna_board_seq) {
        return repository.readqna(qna_board_seq);
    }

    @Override
    public List<QnaReadDTO> getQnaList() {
        return repository.readqnaList();
    }
}

