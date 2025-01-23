package com.accompanist.service;

import com.accompanist.domain.User;
import com.accompanist.dto.LoginRequest;
import com.accompanist.dto.LoginResponse;
import com.accompanist.dto.SignUpRequest;
import com.accompanist.dto.SignUpResponse;
import com.accompanist.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public SignUpResponse signUp(SignUpRequest request) {
        if (userMapper.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())  // 암호화 제거
                .name(request.getName())
                .phone(request.getPhone())
                .build();

        userMapper.insert(user);
        return SignUpResponse.from(user);
    }

    public LoginResponse login(LoginRequest request) {
        User user = userMapper.findByEmail(request.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 잘못되었습니다.");
        }

        if (!request.getPassword().equals(user.getPassword())) {  // 단순 문자열 비교
            throw new IllegalArgumentException("이메일 또는 비밀번호가 잘못되었습니다.");
        }

        return LoginResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}