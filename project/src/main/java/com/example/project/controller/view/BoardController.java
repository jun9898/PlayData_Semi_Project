package com.example.project.controller.view;

import com.example.project.dto.request.review.ReviewCommentDTO;
import com.example.project.dto.request.review.ReviewCommentRecommandDTO;
import com.example.project.dto.request.review.ReviewRecommandDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.service.ReviewCommentService;
import com.example.project.service.ReviewPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/content")
@SessionAttributes("user")
@Slf4j
public class BoardController {

    private final ReviewPostService postservice;
    private final ReviewCommentService commentservice;

    @GetMapping("/feed")
    public String feedView(){
        return "board/feed";
    }

    @GetMapping("/map")
    public String mapView(){
        return "board/map";
    }

    //게시판 상세보기
    @GetMapping("/feed/{review_seq}")
    public String getReviewDetail(@PathVariable("review_seq") Long review_seq, Model model) {
        ReviewPostReadDTO review = postservice.getReviewPost(review_seq);
        List<ReviewCommentReadDTO> comments = commentservice.getReviewComment(review_seq);
        model.addAttribute("review", review);
        model.addAttribute("comments", comments);
        return "board/user-content";
    }

    //게시판 추천 유무 체크하기
    public boolean checkIfAlreadyPostRecommanded(@ModelAttribute ReviewRecommandDTO RecommandDTO) {
        int count = postservice.checkIfAlreadyPostRecommanded(RecommandDTO);
        return count > 0;
    }

    //게시판 추천하기
    @PostMapping("/feed/{review_seq}/add-postrecommand")
    public String addPostCommand(@ModelAttribute ReviewRecommandDTO RecommandDTO) {
        boolean alreadyRecommanded = checkIfAlreadyPostRecommanded(RecommandDTO);
        if (alreadyRecommanded) {
            postservice.deleteReviewRecommand(RecommandDTO);
        } else {
            postservice.insertReviewRecommand(RecommandDTO);
        }
        return "redirect:/content/feed/{review_seq}";
    }

    //댓글 쓰기
    @PostMapping("/feed/{review_seq}/add-comment")
    public String addComment(@PathVariable Long review_seq, @ModelAttribute ReviewCommentDTO commentDTO) {
        commentservice.insertReviewComment(commentDTO);
        return "redirect:/content/feed/{review_seq}";
    }

    //댓글 삭제
    @PostMapping("/feed/{review_seq}/delete-comment/{comment_seq}")
    public String deleteComment(@PathVariable("comment_seq") Long comment_seq) {
        commentservice.deleteReviewComment(comment_seq);
        return "redirect:/content/feed/{review_seq}";
    }

    //댓글 수정하기
    @PostMapping("/feed/{review_seq}/edit-comment/{comment_seq}")
    public String editComment(@PathVariable Long comment_seq, @ModelAttribute ReviewCommentDTO updatedCommentDTO) {
        System.out.println(comment_seq);
        log.info("test");
        commentservice.updateReviewComment(comment_seq, updatedCommentDTO);
        return "redirect:/content/feed/{review_seq}";
    }

    //댓글 추천 유무 체크하기
    public boolean checkIfAlreadyRecommanded(@ModelAttribute ReviewCommentRecommandDTO commentRecommandDTO) {
        int count = commentservice.checkIfAlreadyRecommanded(commentRecommandDTO);
        return count > 0;
    }

    //댓글 추천하기
    @PostMapping("/feed/{review_seq}/add-recommand/{comment_seq}")
    public String addCommand(@PathVariable Long comment_seq, @ModelAttribute ReviewCommentRecommandDTO commentRecommandDTO) {
        boolean alreadyRecommanded = checkIfAlreadyRecommanded(commentRecommandDTO);
        if (alreadyRecommanded) {
            commentservice.deleteReviewCommentRecommand(commentRecommandDTO);
        } else {
            commentservice.insertReviewCommentRecommand(commentRecommandDTO);
        }
        return "redirect:/content/feed/{review_seq}";
    }
}

