package com.example.talktopi.domain.room.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RoomResponse {
    private int id;
    private String roomName;
    private String category;
    private int headcount;
}
