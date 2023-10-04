package com.checku.core.mock;

import com.checku.core.bookmark.application.BookmarkCommandService;
import com.checku.core.bookmark.application.BookmarkQueryService;
import com.checku.core.bookmark.service.port.BookmarkRepository;
import com.checku.core.user.application.UserCommandService;
import com.checku.core.user.application.UserQueryService;
import com.checku.core.user.service.port.UserRepository;

public class CoreTestContainer {

    public final UserRepository userRepository;
    public final UserQueryService userQueryService;
    public final UserCommandService userCommandService;

    public final BookmarkRepository bookmarkRepository;
    public final BookmarkQueryService bookmarkQueryService;
    public final BookmarkCommandService bookmarkCommandService;

    public CoreTestContainer() {
        this.userRepository = new FakeUserRepository();
        this.userQueryService = new UserQueryService(userRepository);
        this.userCommandService = new UserCommandService(userRepository);

        this.bookmarkRepository = new FakeBookmarkRepository();
        this.bookmarkQueryService = new BookmarkQueryService(bookmarkRepository);
        this.bookmarkCommandService = new BookmarkCommandService(bookmarkRepository, bookmarkQueryService);
    }
}
