package com.example.talktopi.domain.user.controller;

import com.example.talktopi.domain.user.controller.dto.request.EditProfileRequest;
import com.example.talktopi.domain.user.controller.dto.response.UserResponse;
import com.example.talktopi.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/mypage")
    public UserResponse getMyProfile() {
        return userService.getMyProfile();
    }

    @GetMapping("/getProfile")
    public UserResponse getProfile(@RequestParam String email) {
        return userService.getProfile(email);
    }

    @PatchMapping("/mypage")
    public void editProfile(@RequestPart EditProfileRequest request,
                            @RequestPart MultipartFile img) throws IOException {
        userService.editMyProfile(request, img);
    }
}
