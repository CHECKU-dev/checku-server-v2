package com.checku.core.mock;

import com.checku.core.mysubject.application.MySubjectCommandService;
import com.checku.core.mysubject.service.port.MySubjectRepository;
import com.checku.core.user.application.UserCommandService;
import com.checku.core.user.service.port.UserRepository;

public class TestContainer {
    public final UserRepository userRepository;
    public final MySubjectRepository mySubjectRepository;
    public final UserCommandService userCommandService;
    public final MySubjectCommandService mySubjectCommandService;

    public TestContainer() {
        this.userRepository = new FakeUserRepository();
        this.mySubjectRepository = new FakeMySubjectRepository();
        this.userCommandService = new UserCommandService(userRepository);
        this.mySubjectCommandService = new MySubjectCommandService(mySubjectRepository);
    }
}
