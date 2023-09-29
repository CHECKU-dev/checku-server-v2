package com.checku.core.mysubject.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MySubjectCreateCommand {
    private final String subjectNumber;
    private final Long userId;

    @Builder
    private MySubjectCreateCommand(String subjectNumber, Long userId) {
        this.subjectNumber = subjectNumber;
        this.userId = userId;
    }
}
