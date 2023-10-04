package com.checku.core.subject.bookmark.infrastructure;

import com.checku.core.subject.bookmark.domain.SubjectBookmark;
import com.checku.core.subject.bookmark.service.port.SubjectBookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SubjectBookmarkRepositoryImpl implements SubjectBookmarkRepository {

    private final SubjectBookmarkJpaRepository subjectBookmarkJpaRepository;

    @Override
    public SubjectBookmark save(final SubjectBookmark subjectBookmark) {
        return subjectBookmarkJpaRepository.save(SubjectBookmarkEntity.from(subjectBookmark)).toModel();
    }

    @Override
    public Optional<SubjectBookmark> findById(final Long id) {
        return subjectBookmarkJpaRepository.findById(id)
                .map(SubjectBookmarkEntity::toModel);
    }

    @Override
    public void delete(final SubjectBookmark subjectBookmark) {
        SubjectBookmarkEntity subjectBookmarkEntity = SubjectBookmarkEntity.from(subjectBookmark);
        subjectBookmarkJpaRepository.delete(subjectBookmarkEntity);
    }
}
