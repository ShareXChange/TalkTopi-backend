package com.example.talktopi.domain.chat.controller;

import com.example.talktopi.domain.chat.entity.Chat;
import com.example.talktopi.domain.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatRepository chatRepository;

    @PostMapping("/chat")
    public Mono<Chat> sendMessage(@RequestBody Chat chat) {
        chat.setCreatedAt(LocalDateTime.now());
        return chatRepository.save(chat);
    }
}
