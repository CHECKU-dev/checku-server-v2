package com.checku.core.subject.bookmark.application;

import com.checku.core.mock.CoreTestContainer;
import com.checku.core.subject.bookmark.domain.SubjectBookmark;
import com.checku.core.subject.bookmark.domain.SubjectBookmarkCreateCommand;
import com.checku.core.subject.bookmark.service.port.SubjectBookmarkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
class SubjectBookmarkCommandServiceTest {

    private final CoreTestContainer testContainer = new CoreTestContainer();
    private final SubjectBookmarkCommandService subjectBookmarkCommandService = testContainer.subjectBookmarkCommandService;
    private final SubjectBookmarkRepository subjectBookmarkRepository = testContainer.subjectBookmarkRepository;

    @Test
    void SubjectBookmarkCreateCommand로_SubjectBookmark를_생성할_수_있다() {
        // given
        String subjectNumber = "0001";
        Long userId = 1L;
        SubjectBookmarkCreateCommand subjectBookmarkCreateCommand = SubjectBookmarkCreateCommand.builder()
                .subjectNumber(subjectNumber)
                .userId(userId)
                .build();

        // when
        SubjectBookmark subjectBookmark = subjectBookmarkCommandService.create(subjectBookmarkCreateCommand);

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(subjectBookmark.getId()).isEqualTo(1L);
            softAssertions.assertThat(subjectBookmark.getSubjectNumber()).isEqualTo(subjectNumber);
            softAssertions.assertThat(subjectBookmark.getUserId()).isEqualTo(userId);
        });
    }

    @Test
    void Id에_해당하는_SubjectBookmark를_삭제할_수_있다() {
        // given
        String subjectNumber = "0001";
        Long userId = 1L;
        SubjectBookmarkCreateCommand subjectBookmarkCreateCommand = SubjectBookmarkCreateCommand.builder()
                .subjectNumber(subjectNumber)
                .userId(userId)
                .build();
        SubjectBookmark savedSubjectBookmark = subjectBookmarkRepository.save(SubjectBookmark.create(subjectBookmarkCreateCommand));

        // when
        subjectBookmarkCommandService.deleteById(savedSubjectBookmark.getId());

        // then
        Optional<SubjectBookmark> result = subjectBookmarkRepository.findById(savedSubjectBookmark.getId());
        assertThat(result).isEmpty();
    }
}
