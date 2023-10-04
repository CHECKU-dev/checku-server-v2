package com.checku.core.bookmark.application;

import com.checku.core.bookmark.service.port.BookmarkRepository;
import com.checku.core.bookmark.domain.Bookmark;
import com.checku.core.bookmark.domain.BookmarkCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkCommandService {

    private final BookmarkRepository bookmarkRepository;
    private final BookmarkQueryService bookmarkQueryService;

    public Bookmark create(final BookmarkCreateCommand bookmarkCreateCommand) {
        Bookmark bookmark = Bookmark.create(bookmarkCreateCommand);
        return bookmarkRepository.save(bookmark);
    }

    public void deleteById(final Long id) {
        Bookmark bookmark = bookmarkQueryService.getById(id);
        bookmarkRepository.delete(bookmark);
    }
}
