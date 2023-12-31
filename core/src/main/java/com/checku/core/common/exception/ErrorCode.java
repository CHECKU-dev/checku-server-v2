package com.checku.core.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Common
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C001", "Internal Server Error"),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "C002", "Entity Not Found")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
