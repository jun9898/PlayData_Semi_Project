package com.example.project.usertest;

import com.example.project.ProjectApplication;
import com.example.project.dto.CreateUserDTO;
import com.example.project.entity.UserEntity;
import com.example.project.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserTest {

    @Autowired
    private UserService service;

    @Test
    public void joinTest() {
        UserEntity user = new UserEntity();
        user.setId("testid");
        user.setEmail("testid@email.com");
        user.setPassword("password");
        user.setName("testName");
        user.setUser_type_cd(1L);
        service.join(user);

    }
}
