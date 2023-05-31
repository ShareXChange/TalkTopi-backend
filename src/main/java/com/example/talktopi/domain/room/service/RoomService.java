package com.example.talktopi.domain.room.service;

import com.example.talktopi.domain.room.controller.dto.request.RoomRequest;
import com.example.talktopi.domain.room.controller.dto.response.RoomResponse;
import com.example.talktopi.domain.room.entity.Room;
import com.example.talktopi.domain.room.exception.RoomNotFoundException;
import com.example.talktopi.domain.room.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    public RoomResponse save(RoomRequest request) {
        Room room = Room.builder()
                .roomName(request.getRoomName())
                .category(request.getCategory())
                .headcount(request.getHeadcount())
                .build();
        roomRepository.save(room);

        return RoomResponse.builder()
                .id(room.getId())
                .roomName(room.getRoomName())
                .category(room.getCategory())
                .headcount(room.getHeadcount())
                .build();
    }

    @Transactional
    public void delete(int roomId) {
        roomRepository.deleteById(roomId);
    }

    @Transactional
    public RoomResponse getRoom(int roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(RoomNotFoundException::new);
        return RoomResponse.builder()
                .id(room.getId())
                .roomName(room.getRoomName())
                .category(room.getCategory())
                .headcount(room.getHeadcount())
                .build();
    }
}
