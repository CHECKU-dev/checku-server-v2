package com.checku.core.mysubject.infrastructure;

import com.checku.core.mysubject.domain.MySubject;
import com.checku.core.mysubject.service.port.MySubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MySubjectRepositoryImpl implements MySubjectRepository {

    private final MySubjectJpaRepository mySubjectJpaRepository;

    @Override
    public MySubject save(MySubject mySubject) {
        return mySubjectJpaRepository.save(MySubjectEntity.from(mySubject)).toModel();
    }

    @Override
    public Optional<MySubject> findById(Long id) {
        return mySubjectJpaRepository.findById(id)
                .map(MySubjectEntity::toModel);
    }

    // delete 같은 메서드는 쓰기 힘들듯?
    // 도메인 엔티티는 DB 엔티티를 모르도록 구현해야하기 때문?
    @Override
    public void deleteById(Long id) {
        mySubjectJpaRepository.deleteById(id);

    }
}
