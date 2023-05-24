package com.example.talktopi.domain.user.service;

import com.example.talktopi.domain.user.controller.dto.request.EditProfileRequest;
import com.example.talktopi.domain.user.controller.dto.response.UserResponse;
import com.example.talktopi.domain.user.entity.User;
import com.example.talktopi.domain.user.exception.UserNotFoundException;
import com.example.talktopi.domain.user.repository.UserRepository;
import com.example.talktopi.global.s3.AwsS3Service;
import com.example.talktopi.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AwsS3Service awsS3Service;

    @Transactional
    public UserResponse getMyProfile() {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        return UserResponse.builder()
                .email(user.getEmail())
                .gender(user.getGender())
                .age(user.getAge())
                .job(user.getJob())
                .mbti(user.getMbti())
                .name(user.getName())
                .image_url(awsS3Service.getImageUrl(user.getProfile_image()))
                .hobby(user.getHobby())
                .nickname(user.getNickname())
                .address(user.getAddress())
                .introduction(user.getIntroduction())
                .build();
    }

    @Transactional
    public UserResponse getProfile(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        return UserResponse.builder()
                .email(user.getEmail())
                .gender(user.getGender())
                .age(user.getAge())
                .job(user.getJob())
                .mbti(user.getMbti())
                .name(user.getName())
                .image_url(awsS3Service.getImageUrl(user.getProfile_image()))
                .hobby(user.getHobby())
                .nickname(user.getNickname())
                .address(user.getAddress())
                .introduction(user.getIntroduction())
                .build();
    }

    @Transactional
    public void editMyProfile(EditProfileRequest request, MultipartFile img) throws IOException {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        awsS3Service.deleteImage(user.getProfile_image());
        String s3ImgName = awsS3Service.upload(img);
        user.editProfile(request, s3ImgName);
    }
}
