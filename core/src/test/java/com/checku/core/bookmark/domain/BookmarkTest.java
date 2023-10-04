package com.checku.core.bookmark.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class BookmarkTest {

    @Test
    void BookmarkCreateCommand로_Bookmark를_생성할_수_있다() {
        // given
        String subjectNumber = "0001";
        Long userId = 1L;
        BookmarkCreateCommand createCommand = BookmarkCreateCommand.builder()
                .subjectNumber(subjectNumber)
                .userId(userId)
                .build();

        // when
        Bookmark bookmark = Bookmark.create(createCommand);

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(bookmark.getId()).isNull();
            softAssertions.assertThat(bookmark.getSubjectNumber()).isEqualTo(subjectNumber);
            softAssertions.assertThat(bookmark.getUserId()).isEqualTo(userId);
            softAssertions.assertThat(bookmark.getCreatedAt()).isNull();
            softAssertions.assertThat(bookmark.getUpdatedAt()).isNull();
        });
    }
}
