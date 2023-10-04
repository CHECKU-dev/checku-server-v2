package com.checku.core.bookmark.application;

import com.checku.core.bookmark.service.port.BookmarkRepository;
import com.checku.core.common.exception.EntityNotFoundException;
import com.checku.core.bookmark.domain.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookmarkQueryService {

    private final BookmarkRepository bookmarkRepository;

    public Bookmark getById(final Long id) {
        return bookmarkRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
