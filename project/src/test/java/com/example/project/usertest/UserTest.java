package com.example.project.usertest;

import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.LoginSessionDTO;
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
        user.setId("test");
        user.setEmail("testid@emai.com");
        user.setPassword("password");
        user.setName("전병준짱짱짱");
        service.join(user);
    }

    @Test
    public void loginTest() {

        // 회원가입
        CreateUserDTO user = new CreateUserDTO();
        user.setId("testid3");
        user.setEmail("testid2@email.com");
        user.setPassword("password");
        user.setName("test");
        service.join(user);

        // 로그인
        LoginUserDTO login = new LoginUserDTO();
        login.setId("testid3");
        login.setPassword("password");
        LoginSessionDTO testUser2 = service.login(login);

//        Assertions.assertThat(user.getName()).isEqualTo(testUser2);
        System.out.println("testUser2 = " + testUser2);






    }
}
