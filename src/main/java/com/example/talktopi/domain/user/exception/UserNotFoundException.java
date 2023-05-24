package com.example.talktopi.domain.user.exception;

import com.example.talktopi.global.error.ErrorCode;
import com.example.talktopi.global.error.exception.CustomException;

public class UserNotFoundException extends CustomException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
