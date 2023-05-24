package com.example.talktopi.domain.room.exception;

import com.example.talktopi.global.error.ErrorCode;
import com.example.talktopi.global.error.exception.CustomException;

public class RoomNotFoundException extends CustomException {
    public RoomNotFoundException() {
        super(ErrorCode.ROOM_NOT_FOUND);
    }
}
