package com.example.project.controller.view;

import com.example.project.dto.request.help.NoticeDTO;
import com.example.project.dto.response.help.NoticeReadDTO;
import com.example.project.dto.response.help.QnaReadDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@SessionAttributes("user")
@Slf4j
public class HelpController {
    private final NoticeService noticeservice;
    @GetMapping("/notice")
    public String noticeView(Model model) {
        List<NoticeReadDTO> noticeList = noticeservice.getNoticeList();
        model.addAttribute("noticeList", noticeList);
        System.out.println(model+"========================");
        return "help/notice";
    }

    @GetMapping("/qna")
    public String qnaView(Model model) {
        List<QnaReadDTO> qnaList = noticeservice.getQnaList();
        model.addAttribute("qnaList", qnaList);
        System.out.println(model+"========================");
        return "help/qna";
    }

    @GetMapping("/qnaview/{qna_board_seq}")
    public String getQnaDetail(@PathVariable("qna_board_seq") Long qna_board_seq, Model model) {
        QnaReadDTO qna = noticeservice.getQna(qna_board_seq);
        model.addAttribute("qna", qna);
        return "help/qna-view";
    }

    @GetMapping("/main-write")
    public String mainwriteView() {
        return "help/main-write";
    }

    @GetMapping("/write")
    public String writeView() {
        return "help/write";
    }

    @GetMapping("/view/{seq}")
    public String getNoticeDetail(@PathVariable("seq") Long seq, Model model) {
        NoticeReadDTO notice = noticeservice.getNotice(seq);
        model.addAttribute("notice", notice);
        return "help/view";
    }


}
