package com.checku.core.subject.bookmark.domain;

import com.checku.core.common.domain.BaseTime;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(callSuper = true)
public class SubjectBookmark extends BaseTime {

    private final Long id;
    private final String subjectNumber;
    private final Long userId;

    @Builder
    private SubjectBookmark(final Long id, final String subjectNumber, final Long userId, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.id = id;
        this.subjectNumber = subjectNumber;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static SubjectBookmark create(final SubjectBookmarkCreateCommand subjectBookmarkCreateCommand) {
        return SubjectBookmark.builder()
                .subjectNumber(subjectBookmarkCreateCommand.getSubjectNumber())
                .userId(subjectBookmarkCreateCommand.getUserId())
                .build();
    }
}
