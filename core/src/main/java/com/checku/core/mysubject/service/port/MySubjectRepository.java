package com.checku.core.mysubject.service.port;

import com.checku.core.mysubject.domain.MySubject;

import java.util.Optional;

public interface MySubjectRepository {

    MySubject save(MySubject mySubject);

    Optional<MySubject> findById(Long id);

    void deleteById(Long id);
}
