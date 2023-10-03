package com.checku.core.user.application;

import com.checku.core.mock.TestContainer;
import com.checku.core.mysubject.application.MySubjectCommandService;
import com.checku.core.mysubject.domain.MySubject;
import com.checku.core.mysubject.domain.MySubjectCreateCommand;
import com.checku.core.mysubject.service.port.MySubjectRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class MySubjectCommandServiceTest {
    TestContainer testContainer = new TestContainer();
    MySubjectRepository mySubjectRepository = testContainer.mySubjectRepository;
    MySubjectCommandService mySubjectCommandService = testContainer.mySubjectCommandService;

    @Test
    void MySubject를_생성할_수_있다() {
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

    @Test
    void MySubject를_삭제할_수_있다() {
        // given
        String subjectNumber = "test";
        Long userId = 1L;
        MySubjectCreateCommand mySubjectCreateCommand = MySubjectCreateCommand.builder()
                .subjectNumber(subjectNumber)
                .userId(userId)
                .build();
        MySubject savedMySubject = mySubjectRepository.save(MySubject.create(mySubjectCreateCommand));

        // when
        mySubjectCommandService.delete(savedMySubject.getId());

        // then
        Optional<MySubject> result = mySubjectRepository.findById(savedMySubject.getId());
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).isEmpty();
        });
    }
}
