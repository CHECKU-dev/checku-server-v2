package com.checku.core.bookmark.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookmarkCreateCommand {

    private final String courseNumber;
    private final Long userId;

    @Builder
    private BookmarkCreateCommand(final String courseNumber, final Long userId) {
        this.courseNumber = courseNumber;
        this.userId = userId;
    }
}
