package com.checku.core.user.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {

    private final Long id;
    private final String pushToken;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    @Builder
    private User(Long id, String pushToken, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.pushToken = pushToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static User create(UserCreateCommand userCreateCommand) {
        return User.builder()
                .pushToken(userCreateCommand.getPushToken())
                .build();
    }
}
