package com.example.project.service;

import com.example.project.Exception.LoginFailException;
import com.example.project.dto.request.user.CreateUserDTO;
import com.example.project.dto.request.user.FollowDTO;
import com.example.project.dto.request.user.LoginUserDTO;
import com.example.project.dto.response.user.*;
import com.example.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(CreateUserDTO member) {
        // spring 시큐리티의 passwordEncoder를 사용해서 CreateUserDTO가 담고있는 password를 암호화 해서 저장해줍니다.
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        repository.join(member);
    }

    @Override
    public UserDTO login(LoginUserDTO login) throws LoginFailException{
        // 로그인하려는 회원의 아이디로 DB에 저장된 password를 가져와 입력한 비밀번호와 일치하는지 비교해줍니다.
        // 로그인에 성공하면 Session에 담을 nickname을 반환해줍니다

        LoginResultDTO user = repository.findById(login.getId());
        UserDTO session = null;

        if (user != null && passwordEncoder.matches(login.getPassword(),user.getPassword())) {
            session = user.toCreateLoginSessionDTO();
        } else {
            throw new LoginFailException();
        }
        return session;
    }

    @Override
    public void deleteUser(Long user_seq) {
        repository.deleteUser(user_seq);
    }

    @Override
    public UserDTO findById(String id) {
        return repository.findById(id).toCreateLoginSessionDTO();
    }

    @Override
    public int findFollow(FollowDTO dto) {
        return repository.findFollow(dto);
    }

    @Override
    public void following(FollowDTO dto) {
        repository.insertFollow(dto);
    }
    @Override
    public void unFollowing(FollowDTO dto) {
        repository.deleteFollow(dto);
    }

    @Override
    public ProfileDTO findProfile(String id) {
        return repository.findProfile(id);
    }

    @Override
    public List<UserfeedDTO> myfeedlist(String id) {
        return repository.feedList(id);
    }

    @Override
    public List<FollowlistDTO> readfollowingList(Long follower_user_seq) {
        return repository.readfollowingList(follower_user_seq);
    }

    @Override
    public List<FollowlistDTO> readfollowerList(Long following_user_seq) {
        return repository.readfollowerList(following_user_seq);
    }


}
