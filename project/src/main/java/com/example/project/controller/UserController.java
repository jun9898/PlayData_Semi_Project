
package com.example.project.controller;

//import com.example.project.service.MemberService;
import com.example.project.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserTestService userTestService;

//    테스트 코드로 user/list의 버튼에서 status값을 가져와 해당 값에 해당하는 정보를 뿌려주는 로직입니다.

//package com.example.project.controller;
//
//import com.example.project.service.MemberService;
//import com.example.project.service.UserTestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/user")
//public class UserTestController {
//
//    @Autowired
//    UserTestService userTestService;
//
////    테스트 코드로 user/list의 버튼에서 status값을 가져와 해당 값에 해당하는 정보를 뿌려주는 로직입니다.
//    @RequestMapping("/{name}")
//    public String TestPath(@PathVariable("name") String name, String status, Model model){
//        if (status != null){
//            model.addAttribute("list",userTestService.testLogic(status));
//        }
//        return "user/"+name;
//    }

    @RequestMapping("/list")
    public String mypage(String status, Model model){
        if (status != null){
            model.addAttribute("list",userTestService.testLogic(status));
        }
        return "user/list";
    }

    @RequestMapping("/mypage")
    public String mypage(){
        return "user/mypage";
    }


}
