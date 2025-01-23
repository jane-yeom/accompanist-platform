package com.accompanist.controller;

import com.accompanist.dto.LoginRequest;
import com.accompanist.dto.LoginResponse;
import com.accompanist.dto.SignUpRequest;
import com.accompanist.dto.SignUpResponse;
import com.accompanist.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j  // 로깅을 위해 추가
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        log.info("Login request received for email: {}", request.getEmail());  // 로깅 추가
        LoginResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request) {
        log.info("Signup request received for email: {}", request.getEmail());  // 로깅 추가
        SignUpResponse response = userService.signUp(request);
        return ResponseEntity.ok(response);
    }
}