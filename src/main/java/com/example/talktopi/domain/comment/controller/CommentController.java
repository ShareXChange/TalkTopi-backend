package com.example.talktopi.domain.comment.controller;

import com.example.talktopi.domain.comment.controller.dto.request.CommentRequest;
import com.example.talktopi.domain.comment.controller.dto.response.CommentResponse;
import com.example.talktopi.domain.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{community_id}")
    public CommentResponse save(@Valid @RequestBody CommentRequest request, @PathVariable int community_id){
        return commentService.save(request, community_id);
    }

    @DeleteMapping("/comment/{comment_id}")
    public void delete(@PathVariable int comment_id){
        commentService.delete(comment_id);
    }

    @GetMapping("/comment/list")
    public List<CommentResponse> commentList(){
        return commentService.commentList();
    }
}
