package com.example.project.usertest;

import com.example.project.dto.user.CreateUserDTO;
import com.example.project.service.UserService;
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
    public void joinTest() {
        CreateUserDTO user = new CreateUserDTO();
        user.setId("testid");
        user.setEmail("testid@email.com");
        user.setPassword("password");
        user.setName("testName");
        service.join(user);

    }
}
