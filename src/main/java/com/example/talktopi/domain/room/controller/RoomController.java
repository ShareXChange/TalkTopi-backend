package com.example.talktopi.domain.room.controller;

import com.example.talktopi.domain.room.controller.dto.request.RoomRequest;
import com.example.talktopi.domain.room.controller.dto.response.RoomResponse;
import com.example.talktopi.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/room")
    public RoomResponse save(@RequestBody RoomRequest request) {
        return roomService.save(request);
    }

    @DeleteMapping("/room/{roomId}")
    public void delete(@PathVariable int roomId) {
        roomService.delete(roomId);
    }

    @GetMapping("/room/{roomId}")
    public RoomResponse getRoom(@PathVariable int roomId) {
        return roomService.getRoom(roomId);
    }
}
