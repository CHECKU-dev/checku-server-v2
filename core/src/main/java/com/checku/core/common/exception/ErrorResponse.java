package com.checku.core.common.exception;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class ErrorResponse {

    private List<String> errorMessages;

    public static ErrorResponse from(final String errorMessage) {
        return ErrorResponse.builder()
                .errorMessages(List.of(errorMessage))
                .build();
    }

    public static ErrorResponse from(final List<String> errorMessages) {
        return ErrorResponse.builder()
                .errorMessages(errorMessages)
                .build();
    }

    public static ErrorResponse serverError() {
        return ErrorResponse.builder()
                .errorMessages(List.of(ErrorCode.INTERNAL_SERVER_ERROR.getMessage()))
                .build();
    }
}
