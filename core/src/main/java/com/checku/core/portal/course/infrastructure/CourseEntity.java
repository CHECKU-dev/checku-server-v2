package com.checku.core.portal.course.infrastructure;

import com.checku.core.common.infrastructure.BaseTimeEntity;
import com.checku.core.portal.course.domain.Course;
import com.checku.core.portal.course.domain.CourseType;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "course")
@EqualsAndHashCode(callSuper = true)
public class CourseEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_number")
    private String courseNumber;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_type")
    @Enumerated(value = EnumType.STRING)
    private CourseType courseType;

    public Course toModel() {
        return Course.builder()
                .id(id)
                .courseNumber(courseNumber)
                .courseName(courseName)
                .courseType(courseType)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public static CourseEntity from(final Course course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.id = course.getId();
        courseEntity.courseNumber = course.getCourseNumber();
        courseEntity.courseName = course.getCourseName();
        courseEntity.courseType = course.getCourseType();
        courseEntity.createdAt = course.getCreatedAt();
        courseEntity.updatedAt = course.getUpdatedAt();
        return courseEntity;
    }
}
