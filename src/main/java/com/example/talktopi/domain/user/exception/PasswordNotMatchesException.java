package com.example.talktopi.domain.user.exception;

import com.example.talktopi.global.error.ErrorCode;
import com.example.talktopi.global.error.exception.CustomException;

public class PasswordNotMatchesException extends CustomException {
    public PasswordNotMatchesException() {
        super(ErrorCode.PASSWORD_NOT_MATCHES);
    }
}
