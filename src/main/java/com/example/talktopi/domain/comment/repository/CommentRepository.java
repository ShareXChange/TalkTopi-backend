package com.example.talktopi.domain.comment.repository;

import com.example.talktopi.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
