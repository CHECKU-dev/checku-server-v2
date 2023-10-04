package com.checku.api.bookmark.response;

import com.checku.core.bookmark.domain.Bookmark;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class BookmarkCreateResponse {

    private final Long bookmarkId;
    private final String subjectNumber;
    private final Long userId;

    public BookmarkCreateResponse(final Bookmark bookmark) {
        this.bookmarkId = bookmark.getId();
        this.subjectNumber = bookmark.getSubjectNumber();
        this.userId = bookmark.getUserId();
    }
}
