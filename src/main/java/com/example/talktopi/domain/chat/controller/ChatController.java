package com.example.talktopi.domain.chat.controller;

import com.example.talktopi.domain.chat.entity.Chat;
import com.example.talktopi.domain.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatRepository chatRepository;

    @PostMapping("/chat")
    public void sendMessage(@RequestBody Chat chat) {
        chat.setCreatedAt(LocalDateTime.now());
        chatRepository.save(chat);
    }

    @CrossOrigin
    @GetMapping(value="/sender/{sender}/receiver/{receiver}",produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getMsg(@PathVariable int sender, @PathVariable int receiver){
        return chatRepository.mFindBySender(sender,receiver)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @CrossOrigin
    @GetMapping(value = "chat/room/{roomNum}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getRoomMsg(@PathVariable int roomNum) {
        return chatRepository.mFindByRoomNum(roomNum)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
