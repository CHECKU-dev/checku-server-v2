package com.checku.api.bookmark;

import com.checku.api.bookmark.request.BookmarkCreateRequest;
import com.checku.api.bookmark.response.BookmarkCreateResponse;
import com.checku.core.bookmark.application.BookmarkCommandService;
import com.checku.core.bookmark.domain.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api/users/{userId}/bookmarks")
@RestController
public class BookmarkApi {

    private final BookmarkCommandService bookmarkCommandService;

    @PostMapping
    public ResponseEntity<BookmarkCreateResponse> create(@PathVariable("userId") final Long userId,
                                                         @Valid @RequestBody final BookmarkCreateRequest request) {
        Bookmark bookmark = bookmarkCommandService.create(request.toCreateCommand(userId));
        return ResponseEntity
                .created(getLocationFrom(bookmark))
                .body(new BookmarkCreateResponse(bookmark));
    }

    private URI getLocationFrom(final Bookmark bookmark) {
        return URI.create(String.format("/api/users/%d/bookmarks/%d", bookmark.getUserId(), bookmark.getId()));
    }
}
