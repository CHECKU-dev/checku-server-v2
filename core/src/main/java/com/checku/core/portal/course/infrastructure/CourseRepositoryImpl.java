package com.checku.core.portal.course.infrastructure;

import com.checku.core.portal.course.domain.Course;
import com.checku.core.portal.course.service.port.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {

    private final CourseJpaRepository courseJpaRepository;

    @Override
    public Course save(Course course) {
        return courseJpaRepository.save(CourseEntity.from(course)).toModel();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseJpaRepository.findById(id)
                .map(CourseEntity::toModel);
    }
}
