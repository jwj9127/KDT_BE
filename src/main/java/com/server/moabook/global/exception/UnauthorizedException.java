package com.server.moabook.global.exception;


import com.server.moabook.global.exception.message.ErrorMessage;

public class UnauthorizedException extends BusinessException {
    public UnauthorizedException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
