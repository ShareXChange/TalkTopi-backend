package com.example.talktopi.domain.community.service;

import com.example.talktopi.domain.community.controller.dto.request.CommunityRequest;
import com.example.talktopi.domain.community.controller.dto.response.CommunityResponse;
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

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;
    @Transactional
    public CommunityResponse save(CommunityRequest request){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Community community = Community.builder()
                .content(request.getContent())
                .user(user)
                .build();

        communityRepository.save(community);

        return CommunityResponse.builder()
                .id(community.getId())
                .content(community.getContent())
                .user(community.getUser())
                .build();
    }

    @Transactional
    public CommunityResponse getCommunity(int communityId) {
        Community community = communityRepository.findById(communityId).orElseThrow(CommunityNotFoundException::new);
        return CommunityResponse.builder()
                .id(community.getId())
                .content(community.getContent())
                .user(community.getUser())
                .build();
    }

    @Transactional
    public void editCommunity(int community_id, CommunityRequest request){
        Community community = communityRepository.findById(community_id).orElseThrow(CommunityNotFoundException::new);
        community.editCommunity(request.getContent());
        communityRepository.save(community);
    }

    @Transactional
    public void delete(int community_id){
        communityRepository.deleteById(community_id);
    }

}
