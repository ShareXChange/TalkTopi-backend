package com.example.talktopi.domain.room.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RoomRequest {
    private String roomName;
    private String category;
    private int headcount;
}
