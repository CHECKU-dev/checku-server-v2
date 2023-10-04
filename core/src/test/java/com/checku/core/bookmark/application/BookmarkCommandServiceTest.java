package com.checku.core.bookmark.application;

import com.checku.core.bookmark.domain.Bookmark;
import com.checku.core.bookmark.service.port.BookmarkRepository;
import com.checku.core.mock.CoreTestContainer;
import com.checku.core.bookmark.domain.BookmarkCreateCommand;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
class BookmarkCommandServiceTest {

    private final CoreTestContainer testContainer = new CoreTestContainer();
    private final BookmarkCommandService bookmarkCommandService = testContainer.bookmarkCommandService;
    private final BookmarkRepository bookmarkRepository = testContainer.bookmarkRepository;

    @Test
    void BookmarkCreateCommand로_Bookmark를_생성할_수_있다() {
        // given
        String subjectNumber = "0001";
        Long userId = 1L;
        BookmarkCreateCommand bookmarkCreateCommand = BookmarkCreateCommand.builder()
                .subjectNumber(subjectNumber)
                .userId(userId)
                .build();

        // when
        Bookmark bookmark = bookmarkCommandService.create(bookmarkCreateCommand);

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(bookmark.getId()).isEqualTo(1L);
            softAssertions.assertThat(bookmark.getSubjectNumber()).isEqualTo(subjectNumber);
            softAssertions.assertThat(bookmark.getUserId()).isEqualTo(userId);
        });
    }

    @Test
    void Id에_해당하는_Bookmark를_삭제할_수_있다() {
        // given
        String subjectNumber = "0001";
        Long userId = 1L;
        BookmarkCreateCommand bookmarkCreateCommand = BookmarkCreateCommand.builder()
                .subjectNumber(subjectNumber)
                .userId(userId)
                .build();
        Bookmark savedBookmark = bookmarkRepository.save(Bookmark.create(bookmarkCreateCommand));

        // when
        bookmarkCommandService.deleteById(savedBookmark.getId());

        // then
        Optional<Bookmark> result = bookmarkRepository.findById(savedBookmark.getId());
        assertThat(result).isEmpty();
    }
}
