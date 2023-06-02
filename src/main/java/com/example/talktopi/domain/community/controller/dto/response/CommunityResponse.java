package com.example.talktopi.domain.community.controller.dto.response;

import com.example.talktopi.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommunityResponse {
    private int id;
    private String content;
    private User user;
}
