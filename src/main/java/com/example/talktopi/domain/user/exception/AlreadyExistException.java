package com.example.talktopi.domain.user.exception;

import com.example.talktopi.global.error.ErrorCode;
import com.example.talktopi.global.error.exception.CustomException;

public class AlreadyExistException extends CustomException {
    public AlreadyExistException() {
        super(ErrorCode.ALREADY_EXIST);
    }
}
