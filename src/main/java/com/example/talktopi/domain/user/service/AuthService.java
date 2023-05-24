package com.example.talktopi.domain.user.service;

import com.example.talktopi.domain.user.controller.dto.request.LoginRequest;
import com.example.talktopi.domain.user.controller.dto.request.SignupRequest;
import com.example.talktopi.domain.user.controller.dto.response.TokenResponse;
import com.example.talktopi.domain.user.entity.User;
import com.example.talktopi.domain.user.exception.AlreadyExistException;
import com.example.talktopi.domain.user.exception.PasswordNotMatchesException;
import com.example.talktopi.domain.user.exception.UserNotFoundException;
import com.example.talktopi.domain.user.repository.UserRepository;
import com.example.talktopi.global.jwt.TokenProvider;
import com.example.talktopi.global.s3.AwsS3Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AwsS3Service awsS3Service;

    @Transactional
    public void signup(SignupRequest request, MultipartFile img) throws IOException {
        if(userRepository.findByEmail(request.getEmail()).isPresent())
            throw new AlreadyExistException();

        String s3FileName = awsS3Service.upload(img);

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .nickname(request.getNickname())
                .age(request.getAge())
                .mbti(request.getMbti())
                .job(request.getJob())
                .profile_image(s3FileName)
                .build();
        userRepository.save(user);
    }

    @Transactional
    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(UserNotFoundException::new);
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new PasswordNotMatchesException();

        String accessToken = tokenProvider.createAccessToken(request.getEmail());
        String refreshToken = tokenProvider.createRefreshToken(request.getEmail());

        return TokenResponse.builder()
                .access(accessToken)
                .refresh(refreshToken)
                .build();
    }
}
