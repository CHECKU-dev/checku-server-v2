package com.checku.core.mock;

import com.checku.core.subject.bookmark.application.SubjectBookmarkCommandService;
import com.checku.core.subject.bookmark.application.SubjectBookmarkQueryService;
import com.checku.core.subject.bookmark.service.port.SubjectBookmarkRepository;
import com.checku.core.user.application.UserCommandService;
import com.checku.core.user.service.port.UserRepository;

public class CoreTestContainer {

    public final UserRepository userRepository;
    public final SubjectBookmarkRepository subjectBookmarkRepository;
    public final UserCommandService userCommandService;
    public final SubjectBookmarkQueryService subjectBookmarkQueryService;
    public final SubjectBookmarkCommandService subjectBookmarkCommandService;

    public CoreTestContainer() {
        this.userRepository = new FakeUserRepository();
        this.subjectBookmarkRepository = new FakeSubjectBookmarkRepository();
        this.userCommandService = new UserCommandService(userRepository);
        this.subjectBookmarkQueryService = new SubjectBookmarkQueryService(subjectBookmarkRepository);
        this.subjectBookmarkCommandService = new SubjectBookmarkCommandService(subjectBookmarkRepository, subjectBookmarkQueryService);
    }
}
