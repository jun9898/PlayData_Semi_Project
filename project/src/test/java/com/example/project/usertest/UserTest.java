package com.example.project.usertest;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.UserDTO;
import com.example.project.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class UserTest {

    @Autowired
    private UserService service;

    @Test
    @Rollback(value = false)
    public void joinTest() {
        CreateUserDTO user = new CreateUserDTO();
        user.setId("test1");
        user.setEmail("testid1@emai.com");
        user.setPassword("password");
        user.setName("전병준짱짱짱짱");
        service.join(user);
    }

    @Test

    public void loginTest() {

        // 회원가입
//        CreateUserDTO user = new CreateUserDTO();
//        user.setId("testid4");
//        user.setEmail("testid4@email.com");
//        user.setPassword("testpass");
//        user.setName("test");
//        user.setPhone_num("0100101010");
//        user.setSigungu_cd("testetest");
//        service.join(user);

        // 로그인
        LoginUserDTO login = new LoginUserDTO();
        login.setId("test1");
        login.setPassword("password");

        // 실패 테스트
//        Assertions.assertThrows(LoginFailException.class,()->{ service.login(login); } );
    }

    @Test
    public void findByIdTest() {
        UserDTO test1 = service.findById("test1");
        System.out.println(test1.toString());

    }
    @Test
    @Rollback(value = false)
    public void deleteTest() {
        service.deleteUser(1L);
    }
}
