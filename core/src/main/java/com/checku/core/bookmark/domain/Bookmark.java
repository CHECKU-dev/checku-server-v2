package com.checku.core.bookmark.domain;

import com.checku.core.common.domain.BaseTime;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Bookmark extends BaseTime {

    private final Long id;
    private final String subjectNumber;
    private final Long userId;

    @Builder
    private Bookmark(final Long id, final String subjectNumber, final Long userId, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.id = id;
        this.subjectNumber = subjectNumber;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Bookmark create(final BookmarkCreateCommand bookmarkCreateCommand) {
        return Bookmark.builder()
                .subjectNumber(bookmarkCreateCommand.getSubjectNumber())
                .userId(bookmarkCreateCommand.getUserId())
                .build();
    }
}
