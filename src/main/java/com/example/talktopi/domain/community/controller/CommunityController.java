package com.example.talktopi.domain.community.controller;

import com.example.talktopi.domain.community.controller.dto.request.CommunityRequest;
import com.example.talktopi.domain.community.controller.dto.response.CommunityResponse;
import com.example.talktopi.domain.community.service.CommunityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommunityController {
    private final CommunityService communityService;

    @PostMapping("/community")
    public CommunityResponse save(@Valid @RequestBody CommunityRequest request) {
        return communityService.save(request);
    }

    @GetMapping("/community/{community_id}")
    public CommunityResponse getCommunity(@PathVariable int community_id){
        return communityService.getCommunity(community_id);
    }

    @PatchMapping("/community/{community_id}")
    public void editCommunity(@PathVariable int community_id, @Valid @RequestBody CommunityRequest request){
        communityService.editCommunity(community_id, request);
    }

    @DeleteMapping("community/{community_id}")
    public void delete(@PathVariable int community_id){
        communityService.delete(community_id);
    }
}
