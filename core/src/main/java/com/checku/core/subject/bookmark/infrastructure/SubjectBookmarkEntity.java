package com.checku.core.subject.bookmark.infrastructure;

import com.checku.core.common.infrastructure.BaseTimeEntity;
import com.checku.core.subject.bookmark.domain.SubjectBookmark;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subject_bookmark")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class SubjectBookmarkEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_number", nullable = false)
    private String subjectNumber;

    @Column(name = "user_id")
    private Long userId;

    public SubjectBookmark toModel() {
        return SubjectBookmark.builder()
                .id(id)
                .subjectNumber(subjectNumber)
                .userId(userId)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public static SubjectBookmarkEntity from(final SubjectBookmark subjectBookmark) {
        SubjectBookmarkEntity subjectBookmarkEntity = new SubjectBookmarkEntity();
        subjectBookmarkEntity.id = subjectBookmark.getId();
        subjectBookmarkEntity.subjectNumber = subjectBookmark.getSubjectNumber();
        subjectBookmarkEntity.createdAt = subjectBookmark.getCreatedAt();
        subjectBookmarkEntity.updatedAt = subjectBookmark.getUpdatedAt();
        return subjectBookmarkEntity;
    }
}
