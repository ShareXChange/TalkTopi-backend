package com.example.talktopi.domain.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class EditProfileRequest {
    private String gender;
    private int age;
    private String job;
    private String mbti;
    private String name;
    private String image_url;
    private String hobby;
    private String nickname;
    private String address;
    private String introduction;
}
