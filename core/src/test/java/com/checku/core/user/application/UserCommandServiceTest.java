package com.checku.core.user.application;

import com.checku.core.mock.CoreTestContainer;
import com.checku.core.user.domain.User;
import com.checku.core.user.domain.UserCreateCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class UserCommandServiceTest {

    private final CoreTestContainer coreTestContainer = new CoreTestContainer();
    private final UserCommandService userCommandService = coreTestContainer.userCommandService;

    @Test
    void UserCreateCommand로_User를_생성할_수_있다() {
        // given
        String pushToken = "testToken";
        UserCreateCommand userCreateCommand = UserCreateCommand.builder()
                .pushToken(pushToken)
                .build();

        // when
        User user = userCommandService.create(userCreateCommand);

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(user.getId()).isEqualTo(1L);
            softAssertions.assertThat(user.getPushToken()).hasToString(pushToken);
            softAssertions.assertThat(user.getCreatedAt()).isNull();
            softAssertions.assertThat(user.getUpdatedAt()).isNull();
        });
    }
}
