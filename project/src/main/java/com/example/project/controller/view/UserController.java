
package com.example.project.controller.view;

//import com.example.project.service.MemberService;

import com.example.project.dto.request.user.FollowDTO;
import com.example.project.dto.response.review.ReviewCommentReadDTO;
import com.example.project.dto.response.review.ReviewPostReadDTO;
import com.example.project.dto.response.user.FollowlistDTO;
import com.example.project.dto.response.user.ProfileDTO;
import com.example.project.dto.response.user.UserDTO;
import com.example.project.dto.response.user.UserfeedDTO;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/profile/{id}")
    public String mypageView(@PathVariable("id")String id,
                             @ModelAttribute(name = "user") UserDTO session,
                             Model model){
        ProfileDTO byId = service.findProfile(id);
        List<UserfeedDTO> myfeedlist = service.myfeedlist(id);
        model.addAttribute("profile", byId);
        model.addAttribute("myfeedlist", myfeedlist);
        if (session.getId().equals(id)){
            log.info("use mypage");
            return "user/mypage";
        } else {
            FollowDTO dto = new FollowDTO(session.getUser_seq(), byId.getUser_seq());
            model.addAttribute("findFollowResult",service.findFollow(dto));
            return "user/profile";
        }
    }

    @GetMapping("/profile/{id}/following")
    public String following(@PathVariable("id")String id,
                            @ModelAttribute(name = "user") UserDTO session){
        log.info(session.getId());
        log.info(id);
        UserDTO byId = service.findById(id);
        FollowDTO dto = new FollowDTO(session.getUser_seq(), byId.getUser_seq() );
        log.info(session.getUser_seq() + "         " + byId.getUser_seq());
        service.following(dto);
        return "redirect:/user/profile/"+id;
    }

    @GetMapping("/profile/{id}/un_following")
    public String unFollowing(@PathVariable("id")String id,
                              @ModelAttribute(name = "user") UserDTO session){
        UserDTO byId = service.findById(id);
        FollowDTO dto = new FollowDTO(session.getUser_seq(), byId.getUser_seq());
        service.unFollowing(dto);
        return "redirect:/user/profile/"+id;
    }

    @GetMapping("/profile/{id}/list_un_following")
    public String listUnFollowing(@PathVariable("id")String id,
                              @ModelAttribute(name = "user") UserDTO session){
        UserDTO byId = service.findById(id);
        FollowDTO dto = new FollowDTO(session.getUser_seq(),byId.getUser_seq());
        service.unFollowing(dto);
        return "redirect:/user/list/following/"+session.getUser_seq();
    }
    @GetMapping("/profile/{id}/list_un_follower")
    public String listUnFollower(@PathVariable("id")String id,
                                  @ModelAttribute(name = "user") UserDTO session){
        UserDTO byId = service.findById(id);
        FollowDTO dto = new FollowDTO(byId.getUser_seq(),session.getUser_seq());
        service.unFollowing(dto);
        return "redirect:/user/list/follower/"+session.getUser_seq();
    }

    @GetMapping("/profile/delete")
    public String deleteUser(Long user_seq){
        service.deleteUser(user_seq);
        return "redirect:/content/feed";
    }

    @GetMapping("/list/follower/{following_user_seq}")
    public String getFollowerList(@PathVariable("following_user_seq") Long following_user_seq, Model model) {

        List<FollowlistDTO> follow = service.readfollowerList(following_user_seq);
        model.addAttribute("follower", follow);
        model.addAttribute("this_user", following_user_seq);
        return "user/list";
    }

    @GetMapping("/list/following/{follower_user_seq}")
    public String getFollowingList(@PathVariable("follower_user_seq") Long follower_user_seq, Model model) {

        List<FollowlistDTO> follow = service.readfollowingList(follower_user_seq);
        model.addAttribute("following", follow);
        model.addAttribute("this_user", follower_user_seq);
        return "user/list";
    }

}
