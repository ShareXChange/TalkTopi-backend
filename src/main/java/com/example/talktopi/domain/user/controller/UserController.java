package com.example.talktopi.domain.user.controller;

import com.example.talktopi.domain.user.controller.dto.response.UserResponse;
import com.example.talktopi.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getMyProfile")
    public UserResponse getMyProfile() {
        return userService.getMyProfile();
    }

    @GetMapping("/getProfile")
    public UserResponse getProfile(@RequestParam String email) {
        return userService.getProfile(email);
    }
}
