package com.checku.core.mysubject.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MySubjectJpaRepository extends JpaRepository<MySubjectEntity, Long> {
}
