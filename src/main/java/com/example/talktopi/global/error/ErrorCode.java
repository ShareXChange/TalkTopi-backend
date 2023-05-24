package com.example.talktopi.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //400
    ALREADY_EXIST(400, "user already exist"),
    PASSWORD_NOT_MATCHES(400, "incorrect password"),

    //404
    USER_NOT_FOUND(404, "user not found"),
    ROOM_NOT_FOUND(404, "room not found");


    private final int httpStatus;
    private final String message;
}
