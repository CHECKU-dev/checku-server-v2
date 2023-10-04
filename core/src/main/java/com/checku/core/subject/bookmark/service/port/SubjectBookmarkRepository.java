package com.checku.core.subject.bookmark.service.port;

import com.checku.core.subject.bookmark.domain.SubjectBookmark;

import java.util.Optional;

public interface SubjectBookmarkRepository {

    SubjectBookmark save(final SubjectBookmark subjectBookmark);

    Optional<SubjectBookmark> findById(final Long id);

    void delete(final SubjectBookmark subjectBookmark);
}
