package com.example.talktopi.domain.comment.repository;

import com.example.talktopi.domain.comment.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
