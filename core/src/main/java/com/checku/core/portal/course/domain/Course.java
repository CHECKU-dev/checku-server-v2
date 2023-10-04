package com.checku.core.portal.course.domain;

import com.checku.core.common.domain.BaseTime;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Course extends BaseTime {

    private final Long id;
    private final String courseNumber;
    private final String courseName;
    private final CourseType courseType;

    @Builder
    private Course(final Long id, final String courseNumber, final String courseName, final CourseType courseType, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.id = id;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseType = courseType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
