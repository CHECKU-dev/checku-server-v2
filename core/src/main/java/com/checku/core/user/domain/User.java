package com.checku.core.user.domain;

import com.checku.core.common.domain.BaseTime;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(callSuper = true)
public class User extends BaseTime {

    private final Long id;
    private final String pushToken;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    @Builder
    private User(final Long id, String pushToken, final LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.pushToken = pushToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static User create(final UserCreateCommand userCreateCommand) {
        return User.builder()
                .pushToken(userCreateCommand.getPushToken())
                .build();
    }
}
