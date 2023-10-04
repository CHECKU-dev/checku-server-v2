package com.checku.core.portal.course.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<CourseEntity, Long> {
}
