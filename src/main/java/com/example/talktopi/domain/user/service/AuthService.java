package com.example.talktopi.domain.user.service;

import com.example.talktopi.domain.user.controller.dto.request.SignupRequest;
import com.example.talktopi.domain.user.entity.User;
import com.example.talktopi.domain.user.exception.AlreadyExistException;
import com.example.talktopi.domain.user.repository.UserRepository;
import com.example.talktopi.global.jwt.TokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent())
            throw new AlreadyExistException();
    }
}
