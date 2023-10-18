
package com.example.project.controller.view;

//import com.example.project.service.MemberService;

import com.example.project.dto.request.user.FollowDTO;
import com.example.project.dto.response.user.ProfileDTO;
import com.example.project.dto.response.user.UserDTO;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        model.addAttribute("profile", byId);
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

    @GetMapping("/profile/delete")
    public String deleteUser(Long user_seq){
        service.deleteUser(user_seq);
        return "redirect:/content/feed";
    }




}
