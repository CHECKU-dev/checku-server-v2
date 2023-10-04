package com.checku.core.user.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class UserTest {

    @Test
    void UserCreateCommand로_User를_생성할_수_있다() {
        // given
        String pushToken = "testToken";
        UserCreateCommand userCreateCommand = UserCreateCommand.builder()
                .pushToken(pushToken)
                .build();

        // when
        User user = User.create(userCreateCommand);

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(user.getId()).isNull();
            softAssertions.assertThat(user.getPushToken()).isEqualTo(pushToken);
            softAssertions.assertThat(user.getCreatedAt()).isNull();
            softAssertions.assertThat(user.getUpdatedAt()).isNull();
        });
    }
}
