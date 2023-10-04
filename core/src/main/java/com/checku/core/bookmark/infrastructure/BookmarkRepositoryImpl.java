package com.checku.core.bookmark.infrastructure;

import com.checku.core.bookmark.service.port.BookmarkRepository;
import com.checku.core.bookmark.domain.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookmarkRepositoryImpl implements BookmarkRepository {

    private final BookmarkJpaRepository bookmarkJpaRepository;

    @Override
    public Bookmark save(final Bookmark bookmark) {
        return bookmarkJpaRepository.save(BookmarkEntity.from(bookmark)).toModel();
    }

    @Override
    public Optional<Bookmark> findById(final Long id) {
        return bookmarkJpaRepository.findById(id)
                .map(BookmarkEntity::toModel);
    }

    @Override
    public void delete(final Bookmark bookmark) {
        BookmarkEntity bookmarkEntity = BookmarkEntity.from(bookmark);
        bookmarkJpaRepository.delete(bookmarkEntity);
    }
}
