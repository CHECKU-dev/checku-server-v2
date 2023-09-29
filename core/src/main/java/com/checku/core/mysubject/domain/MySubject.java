package com.checku.core.mysubject.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MySubject { // 왜 BaseTimeEntity를 노 상속?

    private final Long id;
    private final String subjectNumber;
    private final Long userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    @Builder
    private MySubject(Long id, String subjectNumber, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.subjectNumber = subjectNumber;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static MySubject create(MySubjectCreateCommand mySubjectCreateCommand) {
        return MySubject.builder()
                .subjectNumber(mySubjectCreateCommand.getSubjectNumber())
                .userId(mySubjectCreateCommand.getUserId())
                .build();
    }
}
