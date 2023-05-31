package com.example.talktopi.domain.community.repository;

import com.example.talktopi.domain.community.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Integer> {
}
