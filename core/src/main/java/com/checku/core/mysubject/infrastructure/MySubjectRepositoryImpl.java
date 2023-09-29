package com.checku.core.mysubject.infrastructure;

import com.checku.core.mysubject.domain.MySubject;
import com.checku.core.mysubject.service.port.MySubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MySubjectRepositoryImpl implements MySubjectRepository {

    private final MySubjectJpaRepository mySubjectJpaRepository;

    @Override
    public MySubject save(MySubject mySubject) {
        return mySubjectJpaRepository.save(MySubjectEntity.from(mySubject)).toModel();
    }
}
