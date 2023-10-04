package com.checku.api.bookmark;

import com.checku.api.bookmark.request.BookmarkCreateRequest;
import com.checku.api.bookmark.response.BookmarkCreateResponse;
import com.checku.core.bookmark.domain.Bookmark;
import mock.ApiTestContainer;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class BookmarkApiTest {

    private final ApiTestContainer apiTestContainer = new ApiTestContainer();
    private final BookmarkApi bookmarkApi = apiTestContainer.bookmarkApi;

    @Test
    void BookmarkCreateRequest로_Bookmark를_생성할_수_있다() {
        // given
        Long userId = 1L;
        String subjectNumber = "0001";
        BookmarkCreateResponse expectedCreateResponse = new BookmarkCreateResponse(Bookmark.builder()
                .id(1L)
                .subjectNumber(subjectNumber)
                .userId(userId)
                .build());

        // when
        ResponseEntity<BookmarkCreateResponse> responseEntity = bookmarkApi.create(userId, new BookmarkCreateRequest(subjectNumber));

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
            softAssertions.assertThat(responseEntity.getBody()).isEqualTo(expectedCreateResponse);
        });
    }
}
