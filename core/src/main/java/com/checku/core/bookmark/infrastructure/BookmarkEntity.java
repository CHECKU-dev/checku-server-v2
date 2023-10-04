package com.checku.core.bookmark.infrastructure;

import com.checku.core.common.infrastructure.BaseTimeEntity;
import com.checku.core.bookmark.domain.Bookmark;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bookmark")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class BookmarkEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_number", nullable = false)
    private String courseNumber;

    @Column(name = "user_id")
    private Long userId;

    public Bookmark toModel() {
        return Bookmark.builder()
                .id(id)
                .courseNumber(courseNumber)
                .userId(userId)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public static BookmarkEntity from(final Bookmark bookmark) {
        BookmarkEntity bookmarkEntity = new BookmarkEntity();
        bookmarkEntity.id = bookmark.getId();
        bookmarkEntity.courseNumber = bookmark.getCourseNumber();
        bookmarkEntity.userId = bookmark.getUserId();
        bookmarkEntity.createdAt = bookmark.getCreatedAt();
        bookmarkEntity.updatedAt = bookmark.getUpdatedAt();
        return bookmarkEntity;
    }
}
