package com.checku.core.bookmark.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookmarkCreateCommand {

    private final String subjectNumber;
    private final Long userId;

    @Builder
    private BookmarkCreateCommand(final String subjectNumber, final Long userId) {
        this.subjectNumber = subjectNumber;
        this.userId = userId;
    }
}
