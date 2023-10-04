package com.checku.api.user.response;


import com.checku.core.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {

    private Long id;

    private String pushToken;

    public UserResponse(final User user) {
        this.id = user.getId();
        this.pushToken = user.getPushToken();
    }
}
