package com.checku.core.subject.bookmark.application;

import com.checku.core.mock.CoreTestContainer;
import com.checku.core.subject.bookmark.domain.SubjectBookmark;
import com.checku.core.subject.bookmark.domain.SubjectBookmarkCreateCommand;
import com.checku.core.subject.bookmark.service.port.SubjectBookmarkRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubjectBookmarkQueryServiceTest {

    private final CoreTestContainer coreTestContainer = new CoreTestContainer();
    private final SubjectBookmarkRepository subjectBookmarkRepository = coreTestContainer.subjectBookmarkRepository;
    private final SubjectBookmarkQueryService subjectBookmarkQueryService = coreTestContainer.subjectBookmarkQueryService;

    @Test
    void Id로_SubjectBookmark를_가져올_수_있다() {
        // given
        SubjectBookmark savedSubjectBookmark = subjectBookmarkRepository.save(SubjectBookmark.create(SubjectBookmarkCreateCommand.builder()
                .subjectNumber("0001")
                .userId(1L)
                .build()));

        // when
        SubjectBookmark subjectBookmark = subjectBookmarkQueryService.getById(savedSubjectBookmark.getId());

        // then
        assertThat(subjectBookmark).isEqualTo(savedSubjectBookmark);
    }
}
