package com.checku.core.user.application;

import com.checku.core.common.exception.EntityNotFoundException;
import com.checku.core.mock.CoreTestContainer;
import com.checku.core.user.domain.User;
import com.checku.core.user.domain.UserCreateCommand;
import com.checku.core.user.service.port.UserRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserQueryServiceTest {

    private final CoreTestContainer coreTestContainer = new CoreTestContainer();
    private final UserQueryService userQueryService = coreTestContainer.userQueryService;
    private final UserRepository userRepository = coreTestContainer.userRepository;

    @Test
    void Id로_User를_가져올_수_있다() {
        // given
        User savedUser = userRepository.save(User.create(UserCreateCommand.builder()
                .pushToken("testToken")
                .build()));

        // when
        User user = userQueryService.getById(savedUser.getId());

        // then
        assertThat(user).isEqualTo(savedUser);
    }

    @Test
    void Id에_해당하는_User가_없는데_가져오려고_하면_예외를_발생시킨다() {
        // when & then
        assertThatThrownBy(() -> userQueryService.getById(1L)).isInstanceOf(EntityNotFoundException.class);
    }
}
