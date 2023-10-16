package com.example.project.config;

import com.example.project.Exception.LoginFailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExcepctionControllerAdvice {

//    @ExceptionHandler(LoginFailException.class)
//    public ResponseEntity handleAccessDeniedException(final AccessDeniedException ex) {
//        log.warn("error", ex);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//    }

    // LoginFailException이 발생하면 이를 캐치해서 401에러와 메세지를 담아 리턴한다
    @ExceptionHandler(LoginFailException.class)
    public Object test(Exception e) {
        System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");
    }
}
