package com.checku.core.subject.bookmark.application;

import com.checku.core.subject.bookmark.domain.SubjectBookmark;
import com.checku.core.subject.bookmark.domain.SubjectBookmarkCreateCommand;
import com.checku.core.subject.bookmark.service.port.SubjectBookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectBookmarkCommandService {

    private final SubjectBookmarkRepository subjectBookmarkRepository;
    private final SubjectBookmarkQueryService subjectBookmarkQueryService;

    public SubjectBookmark create(final SubjectBookmarkCreateCommand subjectBookmarkCreateCommand) {
        SubjectBookmark subjectBookmark = SubjectBookmark.create(subjectBookmarkCreateCommand);
        return subjectBookmarkRepository.save(subjectBookmark);
    }

    public void deleteById(final Long id) {
        SubjectBookmark subjectBookmark = subjectBookmarkQueryService.getById(id);
        subjectBookmarkRepository.delete(subjectBookmark);
    }
}
