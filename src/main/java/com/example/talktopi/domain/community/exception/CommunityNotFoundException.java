package com.example.talktopi.domain.community.exception;

import com.example.talktopi.global.error.ErrorCode;
import com.example.talktopi.global.error.exception.CustomException;

public class CommunityNotFoundException extends CustomException {
    public CommunityNotFoundException() {
        super(ErrorCode.COMMUNITY_NOT_FOUND);
    }
}
