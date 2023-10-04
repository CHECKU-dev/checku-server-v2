package com.checku.api.bookmark.response;

import com.checku.core.bookmark.domain.Bookmark;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class BookmarkCreateResponse {

    private final Long bookmarkId;
    private final String courseNumber;
    private final Long userId;

    public BookmarkCreateResponse(final Bookmark bookmark) {
        this.bookmarkId = bookmark.getId();
        this.courseNumber = bookmark.getCourseNumber();
        this.userId = bookmark.getUserId();
    }
}
