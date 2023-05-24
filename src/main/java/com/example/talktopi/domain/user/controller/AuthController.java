package com.example.talktopi.domain.user.controller;

import com.example.talktopi.domain.user.controller.dto.request.LoginRequest;
import com.example.talktopi.domain.user.controller.dto.request.SignupRequest;
import com.example.talktopi.domain.user.controller.dto.response.TokenResponse;
import com.example.talktopi.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestPart SignupRequest request,
                       @RequestPart MultipartFile profile_image) throws IOException {
        authService.signup(request, profile_image);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
