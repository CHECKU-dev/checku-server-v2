package com.checku.core.bookmark.application;

import com.checku.core.bookmark.service.port.BookmarkRepository;
import com.checku.core.mock.CoreTestContainer;
import com.checku.core.bookmark.domain.Bookmark;
import com.checku.core.bookmark.domain.BookmarkCreateCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookmarkQueryServiceTest {

    private final CoreTestContainer coreTestContainer = new CoreTestContainer();
    private final BookmarkRepository bookmarkRepository = coreTestContainer.bookmarkRepository;
    private final BookmarkQueryService bookmarkQueryService = coreTestContainer.bookmarkQueryService;

    @Test
    void Id로_Bookmark를_가져올_수_있다() {
        // given
        Bookmark savedBookmark = bookmarkRepository.save(Bookmark.create(BookmarkCreateCommand.builder()
                .courseNumber("0001")
                .userId(1L)
                .build()));

        // when
        Bookmark bookmark = bookmarkQueryService.getById(savedBookmark.getId());

        // then
        assertThat(bookmark).isEqualTo(savedBookmark);
    }
}
