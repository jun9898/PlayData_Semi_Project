package com.example.project.config;

import com.example.project.dto.response.user.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class APICheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(false);
        if(session!=null) {
            UserDTO user = (UserDTO) session.getAttribute("user");
            if(user==null) {//로그인하지 않은 상태
                response.setStatus(401);
                return false;
            }
        }
        //로그인된 사용자는 다음으로 넘어갈 수 있도록 true리턴
        return true;
    }
}
