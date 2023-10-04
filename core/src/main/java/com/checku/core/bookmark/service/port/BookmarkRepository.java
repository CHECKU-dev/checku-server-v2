package com.checku.core.bookmark.service.port;

import com.checku.core.bookmark.domain.Bookmark;

import java.util.Optional;

public interface BookmarkRepository {

    Bookmark save(final Bookmark bookmark);

    Optional<Bookmark> findById(final Long id);

    void delete(final Bookmark bookmark);
}
