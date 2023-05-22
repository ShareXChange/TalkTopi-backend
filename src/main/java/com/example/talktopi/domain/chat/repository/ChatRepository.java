package com.example.talktopi.domain.chat.repository;

import com.example.talktopi.domain.chat.entity.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {
    @Tailable
    @Query("{sender_idx:?0,receiver_idx:?1}") //해당 쿼리가 동작하게 됨.
    Flux<Chat> mFindBySender(Integer sender, Integer receiver);

    @Tailable
    @Query("{room_num:?0}")
    Flux<Chat> mFindByRoomNum(Integer roomNum);
}
