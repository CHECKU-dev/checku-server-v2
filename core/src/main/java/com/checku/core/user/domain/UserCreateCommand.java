package com.checku.core.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserCreateCommand {

    private final String pushToken;

    @Builder
    private UserCreateCommand(String pushToken) {
        this.pushToken = pushToken;
    }
}
