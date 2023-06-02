package com.example.talktopi.domain.comment.service;

import com.example.talktopi.domain.comment.controller.dto.request.CommentRequest;
import com.example.talktopi.domain.comment.controller.dto.response.CommentResponse;
import com.example.talktopi.domain.comment.entity.Comment;
import com.example.talktopi.domain.comment.repository.CommentRepository;
import com.example.talktopi.domain.community.entity.Community;
import com.example.talktopi.domain.community.exception.CommunityNotFoundException;
import com.example.talktopi.domain.community.repository.CommunityRepository;
import com.example.talktopi.domain.user.entity.User;
import com.example.talktopi.domain.user.exception.UserNotFoundException;
import com.example.talktopi.domain.user.repository.UserRepository;
import com.example.talktopi.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommunityRepository communityRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponse save(CommentRequest request, int community_id) {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Community community = communityRepository.findById(community_id).orElseThrow(CommunityNotFoundException::new);
        Comment comment = Comment.builder()
                .content(request.getContent())
                .user(user)
                .community(community)
                .build();

        commentRepository.save(comment);

        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .user(comment.getUser())
                .community(comment.getCommunity())
                .build();
    }

    @Transactional
    public void delete(int comment_id) {
        commentRepository.deleteById(comment_id);
    }

    @Transactional
    public List<CommentResponse> commentList() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(p -> new CommentResponse(
                p.getId(),
                p.getContent(),
                p.getUser(),
                p.getCommunity())).collect(Collectors.toList());
    }
}