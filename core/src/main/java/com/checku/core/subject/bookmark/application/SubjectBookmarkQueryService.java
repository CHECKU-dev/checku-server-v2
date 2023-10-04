package com.checku.core.subject.bookmark.application;

import com.checku.core.common.exception.EntityNotFoundException;
import com.checku.core.subject.bookmark.domain.SubjectBookmark;
import com.checku.core.subject.bookmark.service.port.SubjectBookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubjectBookmarkQueryService {

    private final SubjectBookmarkRepository subjectBookmarkRepository;

    public SubjectBookmark getById(final Long id) {
        return subjectBookmarkRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
