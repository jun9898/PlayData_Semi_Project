package com.example.project.service;

import com.example.project.Exception.LoginFailException;
import com.example.project.dto.request.CreateUserDTO;
import com.example.project.dto.request.LoginUserDTO;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void join(CreateUserDTO member) {
        // spring 시큐리티의 passwordEncoder를 사용해서 CreateUserDTO가 담고있는 password를 암호화 해서 저장해줍니다.
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        repository.join(member);
    }

    @Override
    public String login(LoginUserDTO login) throws LoginFailException{
        // 로그인하려는 회원의 아이디로 DB에 저장된 password를 가져와 입력한 비밀번호와 일치하는지 비교해줍니다.
        // 로그인에 성공하면 Session에 담을 nickname을 반환해줍니다
        String session = null;
        if (repository.findById(login.getId()) != null) {
            if(passwordEncoder.matches(repository.findById(login.getId()).getPassword(), login.getPassword())) {
                session = repository.findById(login.getId()).getName();
            }
        } else {
            throw new LoginFailException();
        }
        return session;
    }
}
