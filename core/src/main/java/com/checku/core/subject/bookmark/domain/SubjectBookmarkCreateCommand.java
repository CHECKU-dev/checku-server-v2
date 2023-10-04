package com.checku.core.subject.bookmark.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SubjectBookmarkCreateCommand {

    private final String subjectNumber;
    private final Long userId;

    @Builder
    private SubjectBookmarkCreateCommand(final String subjectNumber, final Long userId) {
        this.subjectNumber = subjectNumber;
        this.userId = userId;
    }
}
