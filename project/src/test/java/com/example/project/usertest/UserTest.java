package com.example.project.usertest;

import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.dto.response.LoginResultDTO;
import com.example.project.entity.UserEntity;
import com.example.project.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class UserTest {

    @Autowired
    private UserService service;

    @Test
    @Disabled
    public void joinTest() {
        CreateUserDTO user = new CreateUserDTO();
        user.setId("testid");
        user.setEmail("testid@email.com");
        user.setPassword("password");
        user.setName("testName");
        service.join(user);
    }

    @Test
    public void loginTest() {

        // 회원가입
        CreateUserDTO user = new CreateUserDTO();
        user.setId("testid");
        user.setEmail("testid@email.com");
        user.setPassword("password");
        user.setName("testName");
        service.join(user);

        // 로그인
        LoginUserDTO login = new LoginUserDTO();
        login.setId("testid");
        login.setPassword("password");
        LoginResultDTO testUser2 = service.login(login);






    }
}
