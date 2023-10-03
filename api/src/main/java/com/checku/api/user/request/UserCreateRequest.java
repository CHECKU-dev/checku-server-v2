package com.checku.api.user.request;

import com.checku.core.user.domain.UserCreateCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserCreateRequest {

    @NotNull
    private String pushToken;

    public UserCreateCommand toCreateCommand() {
        return UserCreateCommand.builder()
                .pushToken(pushToken)
                .build();
    }
}
