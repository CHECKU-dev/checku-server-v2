package com.checku.core.mock;

import com.checku.core.user.application.UserCommandService;
import com.checku.core.user.service.port.UserRepository;

public class TestContainer {
    public final UserRepository userRepository;
    public final UserCommandService userCommandService;

    public TestContainer() {
        this.userRepository = new FakeUserRepository();
        this.userCommandService = new UserCommandService(userRepository);
    }
}
