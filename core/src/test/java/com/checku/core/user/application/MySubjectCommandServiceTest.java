package com.checku.core.user.application;

import com.checku.core.mock.CoreTestContainer;
import com.checku.core.mysubject.application.MySubjectCommandService;
import com.checku.core.mysubject.domain.MySubject;
import com.checku.core.mysubject.domain.MySubjectCreateCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class MySubjectCommandServiceTest {

    private final CoreTestContainer testContainer = new CoreTestContainer();
    private final MySubjectCommandService mySubjectCommandService = testContainer.mySubjectCommandService;

    @Test
    void MySubjectCreateCommand로_MySubject를_생성할_수_있다() {
        // given
        String subjectNumber = "test";
        Long userId = 1L;
        MySubjectCreateCommand mySubjectCreateCommand = MySubjectCreateCommand.builder()
                .subjectNumber(subjectNumber)
                .userId(userId)
                .build();

        // when
        MySubject mySubject = mySubjectCommandService.create(mySubjectCreateCommand);

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(mySubject.getId()).isEqualTo(1L);
            softAssertions.assertThat(mySubject.getSubjectNumber()).isEqualTo(subjectNumber);
            softAssertions.assertThat(mySubject.getUserId()).isEqualTo(userId);
        });
    }
}
