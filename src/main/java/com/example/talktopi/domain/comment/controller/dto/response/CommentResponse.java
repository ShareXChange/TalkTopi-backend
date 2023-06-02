package com.example.talktopi.domain.comment.controller.dto.response;

import com.example.talktopi.domain.community.entity.Community;
import com.example.talktopi.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommentResponse {
    private int id;
    private String content;
    private User user;
    private Community community;
}
