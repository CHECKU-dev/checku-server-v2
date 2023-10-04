package com.checku.core.portal.course.service.port;

import com.checku.core.portal.course.domain.Course;

import java.util.Optional;

public interface CourseRepository {

    Course save(final Course course);

    Optional<Course> findById(final Long id);
}
